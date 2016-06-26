package org.wang.elec.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wang.elec.dao.IElecFileUploadDao;
import org.wang.elec.domain.ElecFileUpload;
import org.wang.elec.service.IElecFileUploadService;
import org.wang.elec.utils.DateUtils;
import org.wang.elec.utils.FileUtils;
import org.wang.elec.utils.LuceneUtils;

@Service(IElecFileUploadService.SERVICE_NAME)
@Transactional(readOnly = true)
public class ElecFileUploadServiceImpl implements IElecFileUploadService {

	/**
	 * 资料图书管理Dao
	 */
	@Resource(name = IElecFileUploadDao.SERVICE_NAME)
	IElecFileUploadDao elecFileUploadDao;

	/**
	 * @name:saveFileUpload
	 * @description:保存资料图纸管理（管理员进行文件上传操作）
	 * @author wang
	 * @version V1.0
	 * @create Date: 2016-04-21
	 * @param ElecFileUpload
	 *            :VO对象
	 * @return 无
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveFileUpload(ElecFileUpload elecFileUpload) {
		String progressTime = DateUtils.dateToString(new Date());
		String projId = elecFileUpload.getProjId();
		String belongTo = elecFileUpload.getBelongTo();
		File[] uploads = elecFileUpload.getUploads();
		String[] uploadsFileNames = elecFileUpload.getUploadsFileName();
		String[] comments = elecFileUpload.getComments();

		if (uploads != null && uploads.length > 0) {
			for (int i = 0; i < comments.length; i++) {
				ElecFileUpload fileUpload = new ElecFileUpload();
				fileUpload.setProjId(projId);
				fileUpload.setBelongTo(belongTo);
				fileUpload.setProgressTime(progressTime);
				fileUpload.setFileName(uploadsFileNames[i]);
				String fileUrl = FileUtils.fileUploadReturnPath(uploads[i],
						uploadsFileNames[i], "资料图纸管理");
				fileUpload.setFileUrl(fileUrl);
				fileUpload.setComment(comments[i]);
				elecFileUploadDao.save(fileUpload);
				LuceneUtils.addIndex(fileUpload);
			}
		}
	}

	/**
	 * @name findFileUploadListByCondition
	 * @description 通过选择所属单位和图纸类别的查询条件，查询对应单位和图纸下的文件上传列表，返回 List<ElecFileUpload>
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-23
	 * @param ElecFileUpload
	 *            :VO对象
	 * @return List<ElecFileUpload> :资料图纸的集合
	 */

	@Override
	public List<ElecFileUpload> findFileUploadListByCondition(
			ElecFileUpload elecFileUpload) {
		String condition = "";
		List<Object> paramsList = new ArrayList<Object>();
		String projId = elecFileUpload.getProjId();
		if (StringUtils.isNotBlank(projId) && !projId.equals("0")) {
			condition += " and o.projId=?";
			paramsList.add(projId);
		}
		String belongTo = elecFileUpload.getBelongTo();
		if (StringUtils.isNotBlank(belongTo) && !belongTo.equals("0")) {
			condition += " and o.belongTo=?";
			paramsList.add(belongTo);
		}
		Object[] params = paramsList.toArray();
		Map<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.ProgressTime", "asc");
		List<ElecFileUpload> list = elecFileUploadDao
				.findFileUploadListByCondition(condition, params, orderby);
		return list;
	}

	/**
	 * @name findFileByID
	 * @description 使用主键ID，查询资料图纸信息
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-23
	 * @param Integer
	 *            主键ID
	 * @return ElecFileUpload：资料图纸的对象
	 */

	@Override
	public ElecFileUpload findFileByID(Integer fileID) {
		return elecFileUploadDao.findObjectByID(fileID);
	}

	/**
	 * @name findFileUploadByLuceneCondition
	 * @description 使用lucene组织查询条件查询索引库，使用主键ID查询数据库，返回List<ElecFileUpload>
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-24
	 * @param ElecFileUpload
	 *            VO对象
	 * @return List<ElecFileUpload>：存放上传文件的集合
	 */
	@Override
	public List<ElecFileUpload> findFileUploadByLuceneCondition(
			ElecFileUpload elecFileUpload) {
		List<ElecFileUpload> fileUploadList = new ArrayList<ElecFileUpload>();
		String projId = elecFileUpload.getProjId();
		String belongTo = elecFileUpload.getBelongTo();
		String queryString = elecFileUpload.getQueryString();
		List<ElecFileUpload> list = LuceneUtils.searcherIndexByCondition(
				projId, belongTo, queryString);
		if (list != null && list.size() > 0) {
			for (ElecFileUpload fileUpload : list) {
				Integer seqId = fileUpload.getSeqId();
				String condition = " and o.seqId=?";
				Object[] params = { seqId };
				List<ElecFileUpload> fileList = elecFileUploadDao
						.findFileUploadListByCondition(condition, params, null);
				ElecFileUpload upload = fileList.get(0);
				upload.setFileName(fileUpload.getFileName());
				upload.setComment(fileUpload.getComment());
				fileUploadList.addAll(fileList);
			}
		}
		return fileUploadList;
	}

	/**
	 * @name deleteFileUploadByID
	 * @description 删除资料图纸管理的数据
	 * @author wang
	 * @version V1.0
	 * @createDate 2016-04-24
	 * @param Integer 主键ID
	 * @return 无
	 */
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteFileUploadByID(Integer seqId) {
		ElecFileUpload elecFileUpload= elecFileUploadDao.findObjectByID(seqId);
		String path=ServletActionContext.getServletContext().getRealPath("")+elecFileUpload.getFileUrl();
		if (StringUtils.isNotBlank(path)) {
			File file=new File(path);
			if (file.exists()) {
				file.delete();
			}
		}
		elecFileUploadDao.deleteObjectByIds(seqId);
		LuceneUtils.deleteIndex(seqId);
	}

}

package com.shopping.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.mapper.TbContentMapper;
import com.shopping.pojo.TbContent;
import com.shopping.pojo.TbContentExample;
import com.shopping.pojo.TbContentExample.Criteria;
import com.shopping.service.ContentService;
import com.shopping.utils.JsonUtils;

import redis.clients.jedis.JedisCluster;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Autowired
	private JedisCluster jedisCluster;

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	@Override
	public List<TbContent> getContentList(long contentId) {

		try {
			String result = jedisCluster.hget(INDEX_CONTENT_REDIS_KEY, contentId + "");
			if (!StringUtils.isBlank(result)) {
				List<TbContent> resultList = JsonUtils.jsonToList(result, TbContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentId);

		List<TbContent> list = contentMapper.selectByExample(example);

		try {
			String cacheString = JsonUtils.objectToJson(list);
			jedisCluster.hset(INDEX_CONTENT_REDIS_KEY, contentId + "", cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}

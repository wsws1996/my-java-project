package com.shopping.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shopping.pojo.ItemInfo;
import com.shopping.pojo.ShoppingResult;
import com.shopping.pojo.TbItemDesc;
import com.shopping.pojo.TbItemParamItem;
import com.shopping.service.ItemService;
import com.shopping.utils.HttpClientUtil;
import com.shopping.utils.JsonUtils;

@Service
public class ItemServiceImpl implements ItemService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;

	@Value("${ITEM_INFO_URL}")
	private String ITEM_INFO_URL;

	@Value("${ITEM_DESC_URL}")
	private String ITEM_DESC_URL;

	@Value("${ITEM_PARAM_URL}")
	private String ITEM_PARAM_URL;

	@Override
	public ItemInfo getItemById(Long itemId) {

		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_INFO_URL + itemId);
			if (!StringUtils.isBlank(json)) {
				ShoppingResult shoppingResult = ShoppingResult.formatToPojo(json, ItemInfo.class);
				if (shoppingResult.getStatus() == 200) {
					ItemInfo item = (ItemInfo) shoppingResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getItemDescById(Long itemId) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
			ShoppingResult shoppingResult = ShoppingResult.formatToPojo(json, TbItemDesc.class);

			if (shoppingResult.getStatus() == 200) {
				TbItemDesc itemDesc = (TbItemDesc) shoppingResult.getData();
				String result = itemDesc.getItemDesc();
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getItemParamById(Long itemId) {
		try {
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
			ShoppingResult shoppingResult = ShoppingResult.formatToPojo(json, TbItemParamItem.class);
			if (shoppingResult.getStatus() == 200) {
				TbItemParamItem itemParamItem = (TbItemParamItem) shoppingResult.getData();
				String paramData = itemParamItem.getParamData();

				List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
				StringBuffer sb = new StringBuffer();

				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
				sb.append("    <tbody>\n");
				for (Map m1 : jsonList) {
					sb.append("        <tr>\n");
					sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
					sb.append("        </tr>\n");
					List<Map> list2 = (List<Map>) m1.get("params");
					for (Map m2 : list2) {
						sb.append("        <tr>\n");
						sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
						sb.append("            <td>" + m2.get("v") + "</td>\n");
						sb.append("        </tr>\n");
					}
				}
				sb.append("    </tbody>\n");
				sb.append("</table>");
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}

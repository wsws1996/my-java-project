package com.shopping.service;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.mapper.ItemMapper;
import com.shopping.pojo.Item;
import com.shopping.pojo.ShoppingResult;
import com.shopping.utils.ExceptionUtil;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private SolrServer solrServer;

	@Override
	public ShoppingResult importAllItems() {
		try {
			List<Item> list = itemMapper.getItemList();
			for (Item item : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", item.getId());
				document.setField("item_title", item.getTitle());
				document.setField("item_sell_point", item.getSell_point());
				document.setField("item_price", item.getPrice());
				document.setField("item_image", item.getImage());
				document.setField("item_category_name", item.getCategory_name());
				document.setField("item_desc", item.getItem_des());
				solrServer.add(document);
			}
			solrServer.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ShoppingResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return ShoppingResult.ok();
	}

}

package com.zqs.pojo.other;

import java.util.Date;

import com.zqs.pojo.base.REntity;
import com.zqs.pojo.other.e.Erecmd;

/**
 * 推荐
 * 
 * @author qiushi.zhou  
 * @date 2017年3月2日 下午3:39:27
 */
public class Recommend extends REntity{

	private static final long serialVersionUID = -4124006565183421530L;
	
	private Long actId;
	
	/** 名称 */
	private String name;
	
	/** 类别 {@link Erecmd.java} */
	private int type;
	
	/** 图片 */
	private String image;
	
	/** 路径 */
	private String url;
	
	/** 商品 */
	private Long goodsId;
	
	/** 描述 */
	private String description;
	
	/** 创建人 */
	private Long creatorId;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最新修改人 */
	private Long lastOperatorId;
	
	/** 最新修改时间 */
	private Date lastOperatedTime;

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getLastOperatorId() {
		return lastOperatorId;
	}

	public void setLastOperatorId(Long lastOperatorId) {
		this.lastOperatorId = lastOperatorId;
	}

	public Date getLastOperatedTime() {
		return lastOperatedTime;
	}

	public void setLastOperatedTime(Date lastOperatedTime) {
		this.lastOperatedTime = lastOperatedTime;
	}
	
	
	
}

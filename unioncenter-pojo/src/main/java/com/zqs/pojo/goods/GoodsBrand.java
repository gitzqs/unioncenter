package com.zqs.pojo.goods;

import java.util.Date;

import com.zqs.pojo.base.REntity;
/**
 * 品牌
 * 
 * @author qiushi.zhou  
 * @date 2017年3月2日 下午4:25:58
 */
public class GoodsBrand extends REntity{

	private static final long serialVersionUID = -2475427350333064624L;
	
	private Long brandId;
	
	/** 品牌名称 */
	private String brandName;
	
	/** 品牌图片 */
	private String brandImg;
	
	/** 级别 */
	private int level;
	
	/** 状态 */
	private int status;
	
	/** 创建人 */
	private Long creatorId;
	
	/** 创建时间 */
	private Date creatorTime;
	
	/** 最新修改人 */
	private Long lastOperatorId;
	
	/** 最新修改时间 */
	private Date lastOperatedTime;

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandImg() {
		return brandImg;
	}

	public void setBrandImg(String brandImg) {
		this.brandImg = brandImg;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreatorTime() {
		return creatorTime;
	}

	public void setCreatorTime(Date creatorTime) {
		this.creatorTime = creatorTime;
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

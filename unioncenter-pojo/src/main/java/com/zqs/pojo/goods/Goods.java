package com.zqs.pojo.goods;

import java.util.Date;

import com.zqs.pojo.base.REntity;

public class Goods extends REntity{

	private static final long serialVersionUID = -8669117248764058234L;
	
	private Long goodsId;
	
	/** 商品编码 */
	private String code;
	
	/** 商品名称 */
	private String goodsName;
	
	/** 商品所属类别 */
	private Long typeId;
	
	/** 商品所属品牌 */
	private Long brandId;
	
	/** 展示图片1 */
	private String showImg1;
	
	/** 展示图片2 */
	private String showImg2;
	
	/** 展示图片3 */
	private String showImg3;
	
	/** 展示图片4 */
	private String showImg4;
	
	/** 详情介绍图片 */
	private String introduceImg;
	
	/** 价格 */
	private double price;
	
	/** 库存 */
	private int stock;
	
	/** 创建人 */
	private Long creatorId;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 最新修改人 */
	private Long lastOperatorId;
	
	/** 最新修改时间 */
	private Date lastOperatedTime;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getShowImg1() {
		return showImg1;
	}

	public void setShowImg1(String showImg1) {
		this.showImg1 = showImg1;
	}

	public String getShowImg2() {
		return showImg2;
	}

	public void setShowImg2(String showImg2) {
		this.showImg2 = showImg2;
	}

	public String getShowImg3() {
		return showImg3;
	}

	public void setShowImg3(String showImg3) {
		this.showImg3 = showImg3;
	}

	public String getShowImg4() {
		return showImg4;
	}

	public void setShowImg4(String showImg4) {
		this.showImg4 = showImg4;
	}

	public String getIntroduceImg() {
		return introduceImg;
	}

	public void setIntroduceImg(String introduceImg) {
		this.introduceImg = introduceImg;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
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

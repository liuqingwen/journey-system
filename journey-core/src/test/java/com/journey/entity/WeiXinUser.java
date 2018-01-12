/**
 * Title：LoginByWeiXinPojo.java<br>
 * Date：2015年9月25日 下午5:12:18<br>
 */
package com.journey.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Description:<br>
 * 
 * @author xujinhu
 * @version 1.0
 */
public class WeiXinUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2297362113546282619L;

	/** 普通用户的标识，对当前开发者帐号唯一 */
	private String openid;

	private String nickname; // 昵称

	/** 用户唯一标识,针对一个微信开放平台帐号下的应用，同一用户的unionid是唯一的 */
	private String unionid;

	private String headimgurl; // 头像

	private String errmsg;

	private String errcode;

	@JSONField(name = "NAME")
	private String NAME;

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getOpenid() {
		return openid;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
}

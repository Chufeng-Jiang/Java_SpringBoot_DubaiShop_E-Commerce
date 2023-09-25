package com.yuanlrc.campus_market.entity.admin.dao.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yuanlrc.campus_market.entity.common.SiteSetting;

/**
 * 网站设置dao层
 */
@Repository
public interface SiteSettingDao extends JpaRepository<SiteSetting, Long> {
	
	/**
	 * 根据id查找
	 * @param
	 * @return
	 */
	@Query("select ss from SiteSetting ss where ss.id = 1")
	SiteSetting find();
}

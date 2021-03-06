package com.szyciov.lease.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szyciov.lease.entity.PubDictionary;
import com.szyciov.lease.param.LePersonalorderstatisticsParam;
import com.szyciov.lease.service.LePersonalorderstatisticsService;
import com.szyciov.util.PageBean;

@Controller
public class LePersonalorderstatisticsController {
	public LePersonalorderstatisticsService lePersonalorderstatisticsService;
	@Resource(name = "lePersonalorderstatisticsService")
	public void setOrganCountService(LePersonalorderstatisticsService lePersonalorderstatisticsService) {
		this.lePersonalorderstatisticsService = lePersonalorderstatisticsService;
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/GetPersonalByQuery", method = RequestMethod.POST)
	@ResponseBody
	public PageBean getPersonalByQuery(@RequestBody LePersonalorderstatisticsParam lePersonalorderstatisticsParam)  {
		return lePersonalorderstatisticsService.getPersonalByQuery(lePersonalorderstatisticsParam);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/GetPersonalByQuery1", method = RequestMethod.POST)
	@ResponseBody
	public PageBean getPersonalByQuery1(@RequestBody LePersonalorderstatisticsParam lePersonalorderstatisticsParam)  {
		return lePersonalorderstatisticsService.getPersonalByQuery1(lePersonalorderstatisticsParam);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/PersonalAll", method = RequestMethod.POST)
	@ResponseBody
	public List<LePersonalorderstatisticsParam> getPersonalAll(@RequestBody LePersonalorderstatisticsParam lePersonalorderstatisticsParam)  {
		return lePersonalorderstatisticsService.getPersonalAll(lePersonalorderstatisticsParam);
	}
	//导出
	@RequestMapping(value = "api/LePersonalorderstatistics/PersonalAll1", method = RequestMethod.POST)
	@ResponseBody
	public List<LePersonalorderstatisticsParam> getPersonalAll1(@RequestBody LePersonalorderstatisticsParam lePersonalorderstatisticsParam)  {
		return lePersonalorderstatisticsService.getPersonalAll1(lePersonalorderstatisticsParam);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/PersonalAll2", method = RequestMethod.POST)
	@ResponseBody
	public List<LePersonalorderstatisticsParam> getPersonalAll2(@RequestBody LePersonalorderstatisticsParam lePersonalorderstatisticsParam)  {
		return lePersonalorderstatisticsService.getPersonalAll2(lePersonalorderstatisticsParam);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/Getordertype/{leasesCompanyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<PubDictionary> getordertype(@PathVariable String leasesCompanyId)  {
		return lePersonalorderstatisticsService.getordertype(leasesCompanyId);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/GetPaymethod/{leasesCompanyId}", method = RequestMethod.GET)
	@ResponseBody
	public List<PubDictionary> getPaymethod(@PathVariable String leasesCompanyId)  {
		return lePersonalorderstatisticsService.getPaymethod(leasesCompanyId);
	}
	@RequestMapping(value = "api/LePersonalorderstatistics/getTheUser/{leasesCompanyId}", method = RequestMethod.GET)
	@ResponseBody
	public LePersonalorderstatisticsParam getTheUser(@PathVariable String leasesCompanyId)  {
		return lePersonalorderstatisticsService.getTheUser(leasesCompanyId);
	}

}

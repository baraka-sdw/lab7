package ahpu.ssh.city.action;

import ahpu.ssh.city.service.ProvinceService;
import ahpu.ssh.city.service.impl.ProvinceServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CityAction extends ActionSupport {
    //在Action层创建Service对象
    private ProvinceService provinceService = new ProvinceServiceImpl();

    // 页面中的省份下拉列表
    private int provinceId;

    public String execute() {
        // 获得所有省份并写入action
        ActionContext.getContext().put("all_provinces", provinceService.getAllProvinces());
        // 获得选择的省份下所有的城市并写入action
        ActionContext.getContext().put("cities", provinceService.getCitiesOfProvince(provinceId));
        return "index";
    }

    // gettes and setters
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
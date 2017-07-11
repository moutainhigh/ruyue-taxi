package com.supervision.api.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 3.2.16	网约车平台投资人信息*(PTTZR)
 * Created by 林志伟 on 2017/7/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInvestorInfo extends BasicApi {
//    所属平台公司统一社会信用代码
    private String epCode;
//    investerName
    private String investerName;
//    投资人证件类型
    private String invIdType;
//    投资人证件号码
    private String invIdCode;
//   投资人咨信金额
    private String money;
    @JsonIgnore
    private Integer state;
}
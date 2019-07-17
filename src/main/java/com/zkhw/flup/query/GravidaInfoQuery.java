package com.zkhw.flup.query;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GravidaInfoQuery {

    private String archiveNo;

    private String name;

    private Integer minage;
    
    private Integer maxage;

    private String idNumber;

    private String phone;

    private String provinceCode;

    private String cityCode;

    private String countyCode;

    private String townsCode;

    private String villageCode;

    private String status;
    
    private String startDate;
    
    private String endDate;
}

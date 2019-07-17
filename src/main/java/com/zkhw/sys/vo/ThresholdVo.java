package com.zkhw.sys.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ThresholdVo {

    private String type;

    private String warningMin;

    private String warningMax;

    private String thresholdMin;

    private String thresholdMax;
}

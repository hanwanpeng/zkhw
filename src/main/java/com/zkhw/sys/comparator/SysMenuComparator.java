package com.zkhw.sys.comparator;

import java.util.Comparator;

import com.zkhw.sys.entity.SysMenu;

public class SysMenuComparator implements Comparator<SysMenu>{

	@Override
	public int compare(SysMenu right1, SysMenu right2) {
			Double sortNum1 = right1.getMenuSort();
			Double sortNum2 = right2.getMenuSort();
			if( sortNum1 == null || sortNum2 == null) {
				return -1;
			}else {
				if( sortNum1 > sortNum2 ) {
					return 1;
				}else if ( sortNum1 < sortNum2) {
					return -1;
				}else {
					return 0;
				}
			}
		
	}


}

package com.zkhw.shanxi.bo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import lombok.Setter;

@XmlRootElement(name = "ObjectInstance")
@XmlSeeAlso({ Examination.class, Hospitalized.class, FamilyPractice.class, TakeMedicineCondition.class,
		Vaccination.class, Xdt.class, Ncg.class,Temperature.class,Oxygen.class,Glucose.class,Tolic.class,CheckRecord.class,CheckResult.class,Resident.class,Hypertension.class,Diabetes.class,Elderly.class,OldHguide.class,JKFPVisit.class,DangerDisease.class })
@Setter
public class ExaminationObject {
}

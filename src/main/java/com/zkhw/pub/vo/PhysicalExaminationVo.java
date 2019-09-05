package com.zkhw.pub.vo;

import java.util.Date;
import java.util.List;

import com.zkhw.pub.entity.HospitalizedRecord;
import com.zkhw.pub.entity.TakeMedicineRecord;
import com.zkhw.pub.entity.VaccinationRecord;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PhysicalExaminationVo {

    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String batchNo;

    private String barCode;

    private String dutydoctor;
    
    private String symptom;

    private String symptomOther;

    private String checkDate;

    private String baseTemperature;

    private String baseHeartbeat;

    private String baseRespiratory;

    private Integer baseBloodPressureLeftHigh;

    private Integer baseBloodPressureLeftLow;

    private Integer baseBloodPressureRightHigh;

    private Integer baseBloodPressureRightLow;

    private String baseHeight;

    private String baseWeight;

    private String baseWaist;

    private String baseBmi;

    private String baseHealthEstimate;

    private String baseSelfcareEstimate;

    private String baseCognitionEstimate;

    private String baseCognitionScore;

    private String baseFeelingEstimate;

    private String baseFeelingScore;

    private String baseDoctor;

    private String lifewayExerciseFrequency;

    private String lifewayExerciseTime;

    private String lifewayExerciseYear;

    private String lifewayExerciseType;

    private String lifewayDiet;

    private String lifewaySmokeStatus;

    private String lifewaySmokeNumber;

    private String lifewaySmokeStartage;

    private String lifewaySmokeEndage;

    private String lifewayDrinkStatus;

    private String lifewayDrinkNumber;

    private String lifewayDrinkStop;

    private String lifewayDrinkStopage;

    private String lifewayDrinkStartage;

    private String lifewayDrinkOneyear;

    private String lifewayDrinkType;

    private String lifewayOccupationalDisease;

    private String lifewayJob;

    private String lifewayJobPeriod;

    private String lifewayHazardousDust;

    private String lifewayDustPreventive;

    private String lifewayHazardousRadiation;

    private String lifewayRadiationPreventive;

    private String lifewayHazardousPhysical;

    private String lifewayPhysicalPreventive;

    private String lifewayHazardousChemical;

    private String lifewayChemicalPreventive;

    private String lifewayHazardousOther;

    private String lifewayOtherPreventive;

    private String lifewayDoctor;

    private String organLips;

    private String organTooth;

    private String organHypodontia;

    private String organHypodontiaTopleft;

    private String organHypodontiaTopright;

    private String organHypodontiaBottomleft;

    private String organHypodontiaBottomright;

    private String organCaries;

    private String organCariesTopleft;

    private String organCariesTopright;

    private String organCariesBottomleft;

    private String organCariesBottomright;

    private String organDenture;

    private String organDentureTopleft;

    private String organDentureTopright;

    private String organDentureBottomleft;

    private String organDentureBottomright;

    private String organGuttur;

    private String organVisionLeft;

    private String organVisionRight;

    private String organCorrectedvisionLeft;

    private String organCorrectedvisionRight;

    private String organHearing;

    private String organMovement;

    private String organDoctor;

    private String examinationEye;
    
    private String examinationEyeOther;

    private String examinationSkin;

    private String examinationSkinOther;

    private String examinationSclera;

    private String examinationScleraOther;

    private String examinationLymph;

    private String examinationLymphOther;

    private String examinationBarrelChest;

    private String examinationBreathSounds;
    
    private String examinationBreathOther;

    private String examinationRale;

    private String examinationRaleOther;

    private String examinationHeartRate;

    private String examinationHeartRhythm;

    private String examinationHeartNoise;

    private String examinationAbdomenTenderness;

    private String examinationAbdomenMass;

    private String examinationAbdomenHepatomegaly;

    private String examinationAbdomenSplenomegaly;

    private String examinationAbdomenShiftingdullness;

    private String examinationLowerextremityEdema;

    private String examinationDorsalArtery;

    private String examinationAnus;

    private String examinationAnusOther;

    private String examinationBreast;

    private String examinationBreastOther;

    private String examinationDoctor;

    private String examinationWomanVulva;

    private String examinationWomanVagina;

    private String examinationWomanCervix;

    private String examinationWomanCorpus;

    private String examinationWomanAccessories;

    private String examinationWomanDoctor;

    private String examinationOther;

    private String bloodHemoglobin;

    private String bloodLeukocyte;

    private String bloodPlatelet;

    private String bloodOther;

    private String urineProtein;

    private String glycosuria;

    private String urineAcetoneBodies;

    private String bld;

    private String urineOther;

    private String bloodGlucoseMmol;

    private String bloodGlucoseMg;

    private String cardiogram;

    private String cardiogramImg;

    private String microalbuminuria;

    private String fob;

    private String glycosylatedHemoglobin;

    private String hb;

    private String sgft;

    private String ast;

    private String albumin;

    private String totalBilirubin;

    private String conjugatedBilirubin;

    private String scr;

    private String bloodUrea;

    private String bloodK;

    private String bloodNa;

    private String tc;

    private String tg;

    private String ldl;

    private String hdl;

    private String chestX;

    private String chestxImg;

    private String ultrasoundAbdomen;

    private String abdomenbImg;

    private String otherB;

    private String otherbImg;

    private String cervicalSmear;

    private String other;

    private String cerebrovascularDisease;

    private String cerebrovascularDiseaseOther;

    private String kidneyDisease;

    private String kidneyDiseaseOther;

    private String heartDisease;

    private String heartDiseaseOther;

    private String vascularDisease;

    private String vascularDiseaseOther;

    private String ocularDiseases;

    private String ocularDiseasesOther;

    private String nervousSystemDisease;

    private String otherDisease;

    private String healthEvaluation;
    
    private String abnormal1;

    private String abnormal2;

    private String abnormal3;

    private String abnormal4;    

    private String healthGuidance;

    private String dangerControlling;

    private String targetWeight;
    
    private String adviseBacterin;

    private String dangerControllingOther;

    private String createUser;

    private String createName;

    private String createOrg;

    private String createOrgName;

    private Date createTime;

    List<HospitalizedRecord> hospitals;
    
    List<TakeMedicineRecord> medicines;
    
    List<VaccinationRecord> vaccinations;
}

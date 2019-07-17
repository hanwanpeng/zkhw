package com.zkhw.shanxi.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExaminationVo {
    private String id;

    private String name;

    private String archiveNo;

    private String idNumber;

    private String batchNo;

    private String barCode;
    
    private String checkFlag;

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

    private String lifewayDrinkOther;

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

    private String examinationNoiseOther;

    private String examinationAbdomenTenderness;

    private String examinationTendernessMemo;

    private String examinationAbdomenMass;

    private String examinationMassMemo;

    private String examinationAbdomenHepatomegaly;

    private String examinationHepatomegalyMemo;

    private String examinationAbdomenSplenomegaly;

    private String examinationSplenomegalyMemo;

    private String examinationAbdomenShiftingdullness;

    private String examinationShiftingdullnessMemo;

    private String examinationLowerextremityEdema;

    private String examinationDorsalArtery;

    private String examinationAnus;

    private String examinationAnusOther;

    private String examinationBreast;

    private String examinationBreastOther;

    private String examinationDoctor;

    private String examinationWomanVulva;

    private String examinationVulvaMemo;

    private String examinationWomanVagina;

    private String examinationVaginaMemo;

    private String examinationWomanCervix;

    private String examinationCervixMemo;

    private String examinationWomanCorpus;

    private String examinationCorpusMemo;

    private String examinationWomanAccessories;

    private String examinationAccessoriesMemo;

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

    private String cardiogramMemo;

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

    private String xMemo;

    private String chestxImg;

    private String ultrasoundAbdomen;

    private String ultrasoundMemo;

    private String abdomenbImg;

    private String otherB;

    private String otherbMemo;

    private String otherbImg;

    private String cervicalSmear;

    private String cervicalSmearMemo;

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

    private String nervousDiseaseMemo;

    private String otherDisease;

    private String otherDiseaseMemo;

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

    private String healthAdvice;

    private String createUser;

    private String createName;

    private String createOrg;

    private String createOrgName;

    private Date createTime;

    private String updateUser;

    private String updateName;

    private Date updateTime;

    private Integer uploadStatus;

    private Date uploadTime;

    private String uploadResult;
    
    private String dutydoctor;
    
    private String assessId;
    
    private String tcmPhz;
    
    private String tcmQxz;
    
    private String tcmYangxz;
    
    private String tcmYinxz;
    
    private String tcmTsz;
    
    private String tcmSrz;
    
    private String tcmXyz;
    
    private String tcmQyz;
    
    private String tcmTbz;
}

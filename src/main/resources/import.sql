INSERT INTO FID_MX_MAE_CAT_ESTAT_INSTR(ID_ESTAT,DSC_NOMBR) VALUES (1,'SOLICITADA');
INSERT INTO FID_MX_MAE_CAT_ESTAT_INSTR(ID_ESTAT,DSC_NOMBR) VALUES (2,'ENTREGADA');
INSERT INTO FID_MX_MAE_CAT_ESTAT_INSTR(ID_ESTAT,DSC_NOMBR) VALUES (3,'EN PROCESO');
INSERT INTO FID_MX_MAE_CAT_ESTAT_INSTR(ID_ESTAT,DSC_NOMBR) VALUES (4,'ATENDIDA');
INSERT INTO FID_MX_MAE_CAT_ESTAT_INSTR(ID_ESTAT,DSC_NOMBR) VALUES (5,'RECHAZADA');

INSERT INTO FID_MX_MAE_LIST_INSTR(ID_LIST,DSC_TPO_INSTR,DSC_NOMBR,COD_DOC,DSC_FRMTO,FLG_LAYOU,VAL_ADICI,VAL_INSTR) VALUES(1,'INSTRUCCION PARA MODIFICAR REGIMEN DE INVERSION','CARTA INSTRUCCIONES AL FIDUCIARIO',205,'PDF',0,1,NULL);

INSERT INTO FID_MX_REL_INSTR_NVAS(ID_INSTR_NVAS,FK_ID_LIST,FK_ID_BUC,ID_NO_CONTR,ID_NO_SUBCONTR,ID_FOLIO,FK_ID_ESTAT,FCH_REGIS_INSCT) VALUES(1,1,'123',456,1,9000,1,'21/09/21');

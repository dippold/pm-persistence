-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: pm
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activitystatus`
--

DROP TABLE IF EXISTS `activitystatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activitystatus` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitystatus`
--

LOCK TABLES `activitystatus` WRITE;
/*!40000 ALTER TABLE `activitystatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `activitystatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `masterdata`
--

DROP TABLE IF EXISTS `masterdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `masterdata` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `TYPE` tinyint(1) NOT NULL DEFAULT '0',
  `VALUE` varchar(200) NOT NULL DEFAULT '0',
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '1',
  `ENCRYPTED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=352 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `masterdata`
--

LOCK TABLES `masterdata` WRITE;
/*!40000 ALTER TABLE `masterdata` DISABLE KEYS */;
INSERT INTO `masterdata` VALUES (00000000000000000001,'masterdata.types',2,'[{\'id\':\'1\',\'name\':\'Chave\'},{\'id\':\'2\',\'name\':\'Lista\'}]',1,0),(00000000000000000251,'i18n.yes.pt.br',1,'Sim',1,0),(00000000000000000252,'i18n.no.pt.br',0,'Não                ',1,0),(00000000000000000351,'masterdata.work.package.status',1,'[{\'id\':\'1\',\'name\':\'Chave\'},{\'id\':\'2\',\'name\':\'Lista\'}]',1,1);
/*!40000 ALTER TABLE `masterdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menuitem`
--

DROP TABLE IF EXISTS `menuitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menuitem` (
  `ID` bigint(20) NOT NULL,
  `GROUPNAME` varchar(45) NOT NULL,
  `GROUPORDEID` tinyint(1) NOT NULL DEFAULT '0',
  `ORDERID` tinyint(1) NOT NULL DEFAULT '0',
  `NAME` varchar(45) NOT NULL,
  `RESOURCE` varchar(45) DEFAULT '#',
  `ROLEIDS` varchar(45) NOT NULL DEFAULT '1',
  `TYPE` tinyint(1) NOT NULL DEFAULT '1',
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menuitem`
--

LOCK TABLES `menuitem` WRITE;
/*!40000 ALTER TABLE `menuitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `menuitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  `BLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `COMPANY` varchar(45) NOT NULL,
  `STATE` varchar(45) NOT NULL,
  `ESTIMATEDWORK` varchar(45) NOT NULL DEFAULT '0',
  `STARTDATE` varchar(10) DEFAULT NULL,
  `ENDDATE` varchar(10) DEFAULT NULL,
  `MANAGER` varchar(45) NOT NULL,
  `OBJECTIVES` varchar(200) DEFAULT NULL,
  `JUSTIFICATION` varchar(200) DEFAULT NULL,
  `ASSUMPTIONS` varchar(200) DEFAULT NULL,
  `RESTRICTIONS` varchar(200) DEFAULT NULL,
  `SCRATCHS` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (00000000000000000001,'Project Management Tool',1,0,'FTD Educacional','Realização','2000','2016-02-02','2016-12-30','Fabio Dippold',NULL,NULL,NULL,NULL,NULL),(00000000000000000002,'SalesForce - Controle de Acessos',1,1,'WEG S.A.','Viabilidade econômica','1120','2016-01-01','2016-07-14','Fabio Dippold',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectstatus`
--

DROP TABLE IF EXISTS `projectstatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectstatus` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectstatus`
--

LOCK TABLES `projectstatus` WRITE;
/*!40000 ALTER TABLE `projectstatus` DISABLE KEYS */;
INSERT INTO `projectstatus` VALUES (00000000000000000001,'Backlog portifólio',1),(00000000000000000002,'Priorizado portifolio',1),(00000000000000000003,'Análise viabilidade',1),(00000000000000000004,'Em aprovação',1),(00000000000000000005,'Aprovado',1),(00000000000000000006,'Cancelado',1),(00000000000000000007,'Em planejamento',1),(00000000000000000008,'Em BBP',1),(00000000000000000009,'Em realização',1),(00000000000000000010,'Em preparação final',1),(00000000000000000011,'Go Live',1),(00000000000000000012,'Suporte pos',1);
/*!40000 ALTER TABLE `projectstatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rule`
--

DROP TABLE IF EXISTS `rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rule` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rule`
--

LOCK TABLES `rule` WRITE;
/*!40000 ALTER TABLE `rule` DISABLE KEYS */;
INSERT INTO `rule` VALUES (00000000000000000001,'Admin',1),(00000000000000000002,'GP',1),(00000000000000000003,'Resource',1),(00000000000000000004,'Líder negócio',1);
/*!40000 ALTER TABLE `rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',400);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setupkey`
--

DROP TABLE IF EXISTS `setupkey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setupkey` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  `ENCRYPTED` tinyint(1) NOT NULL DEFAULT '0',
  `USEDESCRIPTION` varchar(50) NOT NULL,
  `THEKEY` varchar(50) NOT NULL,
  `THEVALUE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `THEKEY_UNIQUE` (`THEKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setupkey`
--

LOCK TABLES `setupkey` WRITE;
/*!40000 ALTER TABLE `setupkey` DISABLE KEYS */;
/*!40000 ALTER TABLE `setupkey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `PASSWD` varchar(20) NOT NULL,
  `RULEID` bigint(20) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  `BLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (00000000000000000001,'dippold.br@gmail.com','Fabio Dippold','pm@123',1,1,0),(00000000000000000151,'paulo@gmail.com','Paulo Loss','paulo2013',2,1,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usernotification`
--

DROP TABLE IF EXISTS `usernotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernotification` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NOTIFICATION` varchar(45) NOT NULL,
  `USERID` bigint(20) unsigned zerofill NOT NULL,
  `WASREAD` tinyint(1) NOT NULL DEFAULT '0',
  `RESOURCE` varchar(45) NOT NULL,
  `ENTITYID` bigint(20) unsigned zerofill NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usernotification`
--

LOCK TABLES `usernotification` WRITE;
/*!40000 ALTER TABLE `usernotification` DISABLE KEYS */;
INSERT INTO `usernotification` VALUES (00000000000000000001,'asdasdasa',00000000000000000001,0,'dsdsd',00000000000000000001);
/*!40000 ALTER TABLE `usernotification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workpackage`
--

DROP TABLE IF EXISTS `workpackage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workpackage` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `PROJECTID` bigint(20) unsigned zerofill NOT NULL,
  `POOLER` varchar(45) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `DESCRIPTIONCONSULTANCYACTIVITIES` varchar(200) DEFAULT NULL,
  `DESCRIPTIONTIACTIVITIES` varchar(200) DEFAULT NULL,
  `DESCRIPTIONBASISACTIVITIES` varchar(200) DEFAULT NULL,
  `DESCRIPTIONBUSINESSACTIVITIES` varchar(200) DEFAULT NULL,
  `ASSUMPTIONS` varchar(200) DEFAULT NULL,
  `RESTRICTIONS` varchar(200) DEFAULT NULL,
  `SCRATCHS` varchar(200) DEFAULT NULL,
  `SKILLS` varchar(200) DEFAULT NULL,
  `STARTDATE` varchar(10) DEFAULT NULL,
  `ENDDATE` varchar(10) DEFAULT NULL,
  `ESTIMATEDWORK` int(10) NOT NULL DEFAULT '0',
  `STATUSID` bigint(20) NOT NULL DEFAULT '1',
  `PROGRESSOBSERVATIONS` varchar(200) DEFAULT NULL,
  `COMPLETENESS` int(10) NOT NULL DEFAULT '0',
  `ISSUE` tinyint(1) NOT NULL DEFAULT '0',
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '0',
  `BLOCKED` tinyint(1) NOT NULL DEFAULT '0',
  `COMPLETED` tinyint(1) NOT NULL DEFAULT '0',
  `USERID` bigint(20) NOT NULL,
  `ACCEPTANCECRITERIA` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workpackage`
--

LOCK TABLES `workpackage` WRITE;
/*!40000 ALTER TABLE `workpackage` DISABLE KEYS */;
INSERT INTO `workpackage` VALUES (00000000000000000001,00000000000000000001,'Realização','Testes integrados','Execução de testes manuais com time de negócio e testes automatizados no HP-ALM','Suporte as correções dos defeitos encontrados','Ajudar e orientar o time de negócio nos testes e corrigir os defeitos','','Executar os cenários de testes','','','','','2016-05-02','2016-05-31',0,1,'',0,0,1,1,0,1,''),(00000000000000000002,00000000000000000001,'Bluperint','Treinamento SaleForce.com','Treinamento na plataforma base de desenvolvimento do projeto','Lecionar o treinamento','Participar do treinamento','Não há','Participar do primeiro dia do treinamento para a visão geral da plataforma','Todo o treinamento será executado com recursos das nuvens.','1-Velocidade da internet da área de treinamento; 2-Não temos WIFI no prédio.','','O instrutores ter o skill de desenvolvedor','2016-02-10','2016-02-12',24,2,'O treinamento se inicio conforme planejado',30,0,1,0,0,1,'');
/*!40000 ALTER TABLE `workpackage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workpackagestatus`
--

DROP TABLE IF EXISTS `workpackagestatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workpackagestatus` (
  `ID` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) NOT NULL,
  `SYSTEM` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `NAME_UNIQUE` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workpackagestatus`
--

LOCK TABLES `workpackagestatus` WRITE;
/*!40000 ALTER TABLE `workpackagestatus` DISABLE KEYS */;
INSERT INTO `workpackagestatus` VALUES (00000000000000000001,'Em triagem',1),(00000000000000000002,'Viabilidade econômica',1),(00000000000000000003,'Em Aprovação',1),(00000000000000000004,'Aprovado',1),(00000000000000000005,'Em backlog',1),(00000000000000000006,'Planejado',1),(00000000000000000007,'Em andamento',1),(00000000000000000008,'Em testes',1),(00000000000000000009,'Em aceite',1),(00000000000000000010,'Entregue',1),(00000000000000000011,'Postergado',1),(00000000000000000012,'Cancelado',1);
/*!40000 ALTER TABLE `workpackagestatus` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-11 20:50:43

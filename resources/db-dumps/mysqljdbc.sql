/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`mysqljdbc` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mysqljdbc`;

/*Table structure for table `candidate_skills` */

DROP TABLE IF EXISTS `candidate_skills`;

CREATE TABLE `candidate_skills` (
  `candidate_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  PRIMARY KEY (`candidate_id`,`skill_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `candidate_skills_ibfk_1` FOREIGN KEY (`candidate_id`) REFERENCES `candidates` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `candidate_skills_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `skills` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `candidate_skills` */

insert  into `candidate_skills`(`candidate_id`,`skill_id`) values (133,1),(133,2),(133,3);

/*Table structure for table `candidates` */

DROP TABLE IF EXISTS `candidates`;

CREATE TABLE `candidates` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=134 DEFAULT CHARSET=latin1;

/*Data for the table `candidates` */

insert  into `candidates`(`id`,`first_name`,`last_name`,`dob`,`phone`,`email`) values (1,'Carine ','Schmitt','1980-01-01','(403) 225-5556','carine.s@gmail.com\r'),(2,'Jean','King','1980-01-02','(702) 555-1838','jean.k@gmail.com\r'),(3,'Peter','Ferguson','1980-01-03','(395) 204-5558','peter.f@gmail.com\r'),(4,'Janine ','Labrune','1980-01-04','(406) 785-5588','janine.l@gmail.com\r'),(5,'Jonas ','Bergulfsen','1980-01-05','(798) 955-5888','jonas.b@gmail.com\r'),(6,'Susan','Nelson','1980-01-06','(415) 555-1450','susan.n@gmail.com\r'),(7,'Zbyszek ','Piestrzeniewicz','1980-01-07','(266) 427-5558','zbyszek.p@gmail.com\r'),(8,'Roland','Keitel','1980-01-08','(496) 966-9025','roland.k@gmail.com\r'),(9,'Julie','Murphy','1980-01-09','(650) 555-5787','julie.m@gmail.com\r'),(10,'Kwai','Lee','1980-01-10','(212) 555-7818','kwai.l@gmail.com\r'),(11,'Diego ','Freyre','1980-01-11','(915) 559-4440','diego.f@gmail.com\r'),(12,'Christina ','Berglund','1980-01-12','(921) 123-5550','christina.b@gmail.com\r'),(13,'Jytte ','Petersen','1980-01-13','(311) 235-5500','jytte.p@gmail.com\r'),(14,'Mary ','Saveley','1980-01-14','(783) 255-5500','mary.s@gmail.com\r'),(15,'Eric','Natividad','1980-01-15','(652) 217-5550','eric.n@gmail.com\r'),(16,'Jeff','Young','1980-01-16','(212) 555-7413','jeff.y@yahoo.com\r'),(17,'Kelvin','Leong','1980-01-17','(215) 555-1555','kelvin.l@yahoo.com\r'),(18,'Juri','Hashimoto','1980-01-18','(650) 555-6809','juri.h@yahoo.com\r'),(19,'Wendy','Victorino','1980-01-19','(652) 241-5550','wendy.v@yahoo.com\r'),(20,'Veysel','Oeztan','1980-01-20','(472) 267-3215','veysel.o@yahoo.com\r'),(21,'Keith','Franco','1980-01-21','(203) 555-7845','keith.f@yahoo.com\r'),(22,'Isabel ','de Castro','1980-01-22','(135) 655-5500','isabel.d@yahoo.com\r'),(23,'Martine ','Rancé','1980-01-23','(201) 615-5500','martine.r@yahoo.com\r'),(24,'Marie','Bertrand','1980-01-24','(142) 342-5550','marie.b@yahoo.com\r'),(25,'Jerry','Tseng','1980-01-25','(617) 555-5555','jerry.t@yahoo.com\r'),(26,'Julie','King','1980-01-26','(203) 555-2570','julie.k@yahoo.com\r'),(27,'Mory','Kentary','1980-01-27','(810) 663-4258','mory.k@yahoo.com\r'),(28,'Michael','Frick','1980-01-28','(212) 555-1500','michael.f@yahoo.com\r'),(29,'Matti','Karttunen','1980-01-29','(902) 248-5550','matti.k@yahoo.com\r'),(30,'Rachel','Ashworth','1980-01-30','(171) 555-1555','rachel.a@yahoo.com\r'),(31,'Dean','Cassidy','1980-01-31','(353) 186-2155','dean.c@yahoo.com\r'),(32,'Leslie','Taylor','1980-02-01','(617) 555-8428','leslie.t@yahoo.com\r'),(33,'Elizabeth','Devon','1980-02-02','(171) 555-2282','elizabeth.d@yahoo.com\r'),(34,'Yoshi ','Tamuri','1980-02-03','(604) 555-3392','yoshi.t@yahoo.com\r'),(35,'Miguel','Barajas','1980-02-04','(617) 555-7555','miguel.b@yahoo.com\r'),(36,'Julie','Young','1980-02-05','(626) 555-7265','julie.y@yahoo.com\r'),(37,'Brydey','Walker','1980-02-06','(612) 941-1155','brydey.w@yahoo.com\r'),(38,'Frédérique ','Citeaux','1980-02-07','(886) 015-5500','frédérique.c@yahoo.com\r'),(39,'Mike','Gao','1980-02-08','(852) 225-1155','mike.g@yahoo.com\r'),(40,'Eduardo ','Saavedra','1980-02-09','(932) 034-5550','eduardo.s@yahoo.com\r'),(41,'Mary','Young','1980-02-10','(310) 555-2373','mary.y@yahoo.com\r'),(42,'Horst ','Kloss','1980-02-11','(372) 555-1880','horst.k@yahoo.com\r'),(43,'Palle','Ibsen','1980-02-12','(862) 135-5512','palle.i@yahoo.com\r'),(44,'Jean ','Fresnière','1980-02-13','(514) 555-8054','jean.f@yahoo.com\r'),(45,'Alejandra ','Camino','1980-02-14','(917) 456-5550','alejandra.c@yahoo.com\r'),(46,'Valarie','Thompson','1980-02-15','(760) 555-8146','valarie.t@yahoo.com\r'),(47,'Helen ','Bennett','1980-02-16','(198) 555-8888','helen.b@yahoo.com\r'),(48,'Annette ','Roulet','1980-02-17','(617) 765-5533','annette.r@yahoo.com\r'),(49,'Renate ','Messner','1980-02-18','(690) 555-9840','renate.m@yahoo.com\r'),(50,'Paolo ','Accorti','1980-02-19','(114) 988-5521','paolo.a@yahoo.com\r'),(51,'Daniel','Da Silva','1980-02-20','(331) 466-2755','daniel.d@yahoo.com\r'),(52,'Daniel ','Tonini','1980-02-21','(305) 985-5532','daniel.t@yahoo.com\r'),(53,'Henriette ','Pfalzheim','1980-02-22','(221) 555-4327','henriette.p@yahoo.com\r'),(54,'Elizabeth ','Lincoln','1980-02-23','(604) 555-4555','elizabeth.l@yahoo.com\r'),(55,'Peter ','Franken','1980-02-24','(890) 877-5550','peter.f@yahoo.com\r'),(56,'Anna','O\'Hara','1980-02-25','(299) 368-5550','anna.o@yahoo.com\r'),(57,'Giovanni ','Rovelli','1980-02-26','(356) 405-5500','giovanni.r@yahoo.com\r'),(58,'Adrian','Huxley','1980-02-27','(612) 949-5855','adrian.h@yahoo.com\r'),(59,'Marta','Hernandez','1980-02-28','(617) 555-8555','marta.h@yahoo.com\r'),(60,'Ed','Harrison','1980-02-29','(412) 642-5500','ed.h@yahoo.com\r'),(61,'Mihael','Holz','1980-03-01','(897) 034-5550','mihael.h@yahoo.com\r'),(62,'Jan','Klaeboe','1980-03-02','(472) 212-1555','jan.k@yahoo.com\r'),(63,'Bradley','Schuyler','1980-03-03','(312) 049-1955','bradley.s@yahoo.com\r'),(64,'Mel','Andersen','1980-03-04','(300) 074-5550','mel.a@yahoo.com\r'),(65,'Pirkko','Koskitalo','1980-03-05','(981) 443-6550','pirkko.k@yahoo.com\r'),(66,'Catherine ','Dewey','1980-03-06','(255) 546-7000','catherine.d@yahoo.com\r'),(67,'Steve','Frick','1980-03-07','(914) 555-4562','steve.f@yahoo.com\r'),(68,'Wing','Huang','1980-03-08','(508) 555-9555','wing.h@yahoo.com\r'),(69,'Julie','Brown','1980-03-09','(650) 555-1386','julie.b@yahoo.com\r'),(70,'Mike','Graham','1980-03-10','(649) 312-5555','mike.g@yahoo.com\r'),(71,'Ann ','Brown','1980-03-11','(171) 555-0297','ann.b@yahoo.com\r'),(72,'William','Brown','1980-03-12','(201) 555-9350','william.b@yahoo.com\r'),(73,'Ben','Calaghan','1980-03-13','(617) 384-4655','ben.c@yahoo.com\r'),(74,'Kalle','Suominen','1980-03-14','(358) 980-4555','kalle.s@yahoo.com\r'),(75,'Philip ','Cramer','1980-03-15','(555) 095-5500','philip.c@yahoo.com\r'),(76,'Francisca','Cervantes','1980-03-16','(215) 555-4695','francisca.c@yahoo.com\r'),(77,'Jesus','Fernandez','1980-03-17','(349) 137-2855','jesus.f@yahoo.com\r'),(78,'Brian','Chandler','1980-03-18','(215) 555-4369','brian.c@yahoo.com\r'),(79,'Patricia ','McKenna','1980-03-19','(296) 755-5000','patricia.m@yahoo.com\r'),(80,'Laurence ','Lebihan','1980-03-20','(912) 445-5500','laurence.l@yahoo.com\r'),(81,'Paul ','Henriot','1980-03-21','(264) 715-5500','paul.h@yahoo.com\r'),(82,'Armand','Kuger','1980-03-22','(272) 155-0355','armand.k@yahoo.com\r'),(83,'Wales','MacKinlay','1980-03-23','(649) 376-3555','wales.m@yahoo.com\r'),(84,'Karin','Josephs','1980-03-24','(251) 555-2590','karin.j@yahoo.com\r'),(85,'Juri','Yoshido','1980-03-25','(617) 555-9555','juri.y@yahoo.com\r'),(86,'Dorothy','Young','1980-03-26','(603) 555-8647','dorothy.y@yahoo.com\r'),(87,'Lino ','Rodriguez','1980-03-27','(135) 425-5500','lino.r@yahoo.com\r'),(88,'Braun','Urs','1980-03-28','(452) 076-5550','braun.u@yahoo.com\r'),(89,'Allen','Nelson','1980-03-29','(617) 555-8555','allen.n@yahoo.com\r'),(90,'Pascale ','Cartrain','1980-03-30','(712) 367-2555','pascale.c@yahoo.com\r'),(91,'Georg ','Pipps','1980-03-31','(656) 295-5500','georg.p@yahoo.com\r'),(92,'Arnold','Cruz','1980-04-01','(632) 555-3587','arnold.c@yahoo.com\r'),(93,'Maurizio ','Moroni','1980-04-02','(522) 556-5550','maurizio.m@yahoo.com\r'),(94,'Akiko','Shimamura','1980-04-03','(813) 358-4055','akiko.s@yahoo.com\r'),(95,'Dominique','Perrier','1980-04-04','(147) 556-5550','dominique.p@yahoo.com\r'),(96,'Rita ','Müller','1980-04-05','(711) 555-3610','rita.m@yahoo.com\r'),(97,'Sarah','McRoy','1980-04-06','(449) 995-5500','sarah.m@yahoo.com\r'),(98,'Michael','Donnermeyer','1980-04-07','(498) 961-0895','michael.d@yahoo.com\r'),(99,'Maria','Hernandez','1980-04-08','(212) 555-8493','maria.h@yahoo.com\r'),(100,'Alexander ','William','1980-04-09','(342) 555-1760','alexander.f@yahoo.com\r'),(101,'Dan','Grohe','1980-04-10','(203) 555-4407','dan.l@yahoo.com\r'),(102,'Martha','Larsson','1980-04-11','(695) 346-5550','martha.l@yahoo.com\r'),(103,'Sue','Frick','1980-04-12','(408) 555-3659','sue.f@yahoo.com\r'),(104,'Roland ','Mendel','1980-04-13','(767) 535-5500','roland.m@outlook.com\r'),(105,'Leslie','Murphy','1980-04-14','(203) 555-9545','leslie.m@outlook.com\r'),(106,'Yu','Choi','1980-04-15','(212) 555-1957','yu.c@outlook.com\r'),(107,'Martín ','Sommer','1980-04-16','(915) 552-2820','martín.s@outlook.com\r'),(108,'Sven ','Ottlieb','1980-04-17','(241) 039-1230','sven.o@outlook.com\r'),(109,'Violeta','Benitez','1980-04-18','(508) 555-2555','violeta.b@outlook.com\r'),(110,'Carmen','Anton','1980-04-19','(349) 137-2855','carmen.a@outlook.com\r'),(111,'Sean','Clenahan','1980-04-20','(619) 384-4650','sean.c@outlook.com\r'),(112,'Franco','Ricotti','1980-04-21','(390) 225-1550','franco.r@outlook.com\r'),(113,'Steve','Thompson','1980-04-22','(310) 555-3722','steve.t@outlook.com\r'),(114,'Hanna ','Moos','1980-04-23','(621) 085-5522','hanna.m@outlook.com\r'),(115,'Alexander ','Semenov','1980-04-24','(781) 229-3052','alexander.s@outlook.com\r'),(116,'José Pedro ','Roel','1980-04-26','(955) 558-2820','josé pedro.r@outlook.com\r'),(117,'Rosa','Salazar','1980-04-27','(215) 555-9857','rosa.s@outlook.com\r'),(118,'Sue','Taylor','1980-04-28','(415) 555-4312','sue.t@outlook.com\r'),(119,'Thomas ','Smith','1980-04-29','(171) 555-7555','thomas.s@outlook.com\r'),(120,'Valarie','Franco','1980-04-30','(617) 555-2555','valarie.f@outlook.com\r'),(121,'Tony','Snowden','1980-05-01','(649) 555-5500','tony.s@outlook.com\r'),(133,'John','Doe','1990-01-04','(408) 898-5641','john.d@yahoo.com');

/*Table structure for table `skills` */

DROP TABLE IF EXISTS `skills`;

CREATE TABLE `skills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `skills` */

insert  into `skills`(`id`,`name`) values (1,'Java'),(2,'JDBC'),(3,'MySQL'),(4,'Web Application'),(5,'Mobile App');

/* Procedure structure for procedure `get_candidate_skill` */

/*!50003 DROP PROCEDURE IF EXISTS  `get_candidate_skill` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `get_candidate_skill`(IN candidate_id INT)
BEGIN
	SELECT candidates.id, first_name,last_name, skills.name AS skill 
	FROM candidates
	INNER JOIN candidate_skills ON candidates.id = candidate_skills.candidate_id
	INNER JOIN skills ON skills.id = candidate_skills.skill_id
	WHERE candidates.id = candidate_id;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

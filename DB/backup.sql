-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.6.5-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- ridibooks 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `ridibooks`;
CREATE DATABASE IF NOT EXISTS `ridibooks` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `ridibooks`;

-- 테이블 ridibooks.member 구조 내보내기
DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `Id_Num` int(11) NOT NULL AUTO_INCREMENT,
  `Id` varchar(20) NOT NULL,
  `Pw` varchar(18) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `Name` varchar(17) DEFAULT NULL,
  `Birth` int(11) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `m_redate` datetime DEFAULT NULL,
  `m_date` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Num`),
  UNIQUE KEY `Email_Name` (`Email`,`Name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT='회원가입 때 입력한 정보';

-- 테이블 데이터 ridibooks.member:~0 rows (대략적) 내보내기
DELETE FROM `member`;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

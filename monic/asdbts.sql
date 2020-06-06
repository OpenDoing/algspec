/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : asdbts

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2020-06-06 11:01:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `equation`
-- ----------------------------
DROP TABLE IF EXISTS `equation`;
CREATE TABLE `equation` (
  `SpecID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `SID` varchar(50) NOT NULL,
  `AxIndex` int(11) NOT NULL,
  `EqIndex` int(11) NOT NULL,
  `SubEqIndex` int(11) NOT NULL,
  `CondIndex` int(11) NOT NULL,
  `LTerm` varchar(200) DEFAULT NULL,
  `LTType` varchar(50) DEFAULT NULL,
  `Relation` varchar(50) DEFAULT NULL,
  `RTerm` varchar(200) DEFAULT NULL,
  `RTType` varchar(50) DEFAULT NULL,
  `Flag` varchar(50) NOT NULL,
  `EqFlag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SpecID`,`SubSpecID`,`SID`,`AxIndex`,`EqIndex`,`SubEqIndex`,`CondIndex`,`Flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equation
-- ----------------------------
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'AddRequest', '0', '0', '0', '1', 'ar.name', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'AddRequest', '0', '1', '0', '1', 'ar.name.length', 'String', '<=', '20', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'CommonParameter', '0', '0', '0', '1', 'cp.api_Key', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'CommonParameter', '0', '1', '0', '1', 'cp.sig', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'CommonParameter', '0', '2', '0', '1', 'cp.v', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'EditDeleteResponse', '0', '0', '0', '1', 'edr.summary.total', 'Integer', '=', '1', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'EditDeleteResponse', '0', '1', '0', '1', 'edr.summary.start', 'Integer', '=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'EditDeleteResponse', '0', '2', '0', '1', 'edr.summary.returned', 'Integer', '=', 'edr.summary.total', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GetAddResponse', '0', '0', '0', '1', 'gar.summary.total', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GetAddResponse', '0', '1', '0', '1', 'gar.summary.start', 'Integer', '=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GetAddResponse', '0', '2', '0', '1', 'gar.summary.returned', 'Integer', '=', 'gar.summary.total', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', '0', '0', '0', '0', 'gr.headerFields[].header.RH2Str', 'String', '=', '\"Host\"', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', '0', '0', '0', '1', 'gr.headerFields[].value', 'String', '=', '\"//api.gogrid.com/api\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', '0', '1', '0', '1', 'gr.B2Str', 'String', '=', 'gr.body', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridResponse', '0', '0', '0', '1', 'gr.B2Str', 'String', '=', 'gr.body', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListRequest', '0', '0', '0', '1', 'lr.num_items', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListRequest', '0', '1', '0', '0', 'lr.num_items', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListRequest', '0', '1', '0', '1', 'lr.page', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListResponse', '0', '0', '0', '1', 'lr.summary.total', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListResponse', '0', '1', '0', '1', 'lr.summary.start', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListResponse', '0', '2', '0', '1', 'lr.summary.returned', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListResponse', '0', '3', '0', '1', 'lr.summary.numpages', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'HTTPMethod', '0', '0', '0', '1', 'PUT.HM2Str', 'String', '=', '\"PUT\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'HTTPMethod', '0', '1', '0', '1', 'POST.HM2Str', 'String', '=', '\"POST\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'HTTPMethod', '0', '2', '0', '1', 'GET.HM2Str', 'String', '=', '\"GET\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'HTTPMethod', '0', '3', '0', '1', 'DELETE.HM2Str', 'String', '=', '\"DELETE\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'RequestHeader', '0', '0', '0', '1', 'Accept.RH2Str', 'String', '=', '\"Accept\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'RequestHeader', '0', '1', '0', '1', 'Host.RH2Str', 'String', '=', '\"Host\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '0', '0', '1', 'url.Scheme', 'String', '=', '\"http\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '1', '0', '1', 'url.URL2MSG.server', 'String', '=', 'url.Host', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '2', '0', '1', 'url.URL2MSG.path', 'String', '=', 'url.Path', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '3', '0', '0', 'url.URL2MSG.method.HM2Str', 'String', '=', '\"GET\"', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '3', '0', '1', 'url.URL2MSG.headerFields[].RHF2Str', 'String', '=', 'url.Query_string.QS2Str', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '4', '0', '0', 'url.URL2MSG.method.HM2Str', 'String', '=', '\"POST\"', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '4', '0', '1', 'url.URL2MSG.body', 'String', '=', 'url.QS2Body', 'unknownOp!', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Option.as', 'Customer', '0', '0', '0', '1', 'c.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Option.as', 'IPO', '0', '0', '0', '1', 'io.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Option.as', 'Option', '0', '0', '0', '1', 'o.id', 'Integer', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Option.as', 'Server', '0', '0', '0', '1', 's.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerAddResponse', '0', '0', '0', '1', 'sar.request_method', 'String', '=', '\"/grid/server/add\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '0', '0', '0', 'sdr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '0', '0', '1', 'sdr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '1', '0', '0', 'sdr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '1', '0', '1', 'sdr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '2', '0', '0', 'sdr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '2', '0', '1', 'sdr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '3', '0', '0', 'sdr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '3', '0', '1', 'sdr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '4', '0', '0', 'sdr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '4', '0', '1', 'sdr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '5', '0', '0', 'sdr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '5', '0', '1', 'sdr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteResponse', '0', '0', '0', '1', 'sdr.request_method', 'String', '=', '\"/grid/server/delete\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '0', '0', '0', 'ser.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '0', '0', '1', 'ser.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '1', '0', '0', 'ser.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '1', '0', '1', 'ser.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '2', '0', '0', 'ser.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '2', '0', '1', 'ser.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '3', '0', '0', 'ser.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '3', '0', '1', 'ser.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '4', '0', '0', 'ser.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '4', '0', '1', 'ser.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '5', '0', '0', 'ser.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '5', '0', '1', 'ser.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditResponse', '0', '0', '0', '1', 'ser.request_method', 'String', '=', '\"/grid/server/edit\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '0', '0', '0', 'sgr.id', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '0', '0', '1', 'sgr.name', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '1', '0', '0', 'sgr.id', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '1', '0', '1', 'sgr.server', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '2', '0', '0', 'sgr.name', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '2', '0', '1', 'sgr.id', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '3', '0', '0', 'sgr.name', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '3', '0', '1', 'sgr.server', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '4', '0', '0', 'sgr.server', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '4', '0', '1', 'sgr.id', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '5', '0', '0', 'sgr.server', 'unknownOp!', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '5', '0', '1', 'sgr.name', 'unknownOp!', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetResponse', '0', '0', '0', '1', 'sgr.request_method', 'unknownOp!', '=', '\"/grid/server/get\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerListResponse', '0', '0', '0', '1', 'slr.request_method', 'String', '=', '\"/grid/server/list\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '0', '0', '0', 'spr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '0', '0', '1', 'spr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '1', '0', '0', 'spr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '1', '0', '1', 'spr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '2', '0', '0', 'spr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '2', '0', '1', 'spr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '3', '0', '0', 'spr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '3', '0', '1', 'spr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '4', '0', '0', 'spr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '4', '0', '1', 'spr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '5', '0', '0', 'spr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '5', '0', '1', 'spr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerResponse', '0', '0', '0', '1', 'spr.request_method', 'String', '=', '\"/grid/server/power\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'AddRequest', '0', '0', '0', '1', 'ar.name', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'CommonParameter', '0', '0', '0', '1', 'cp.api_Key', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'CommonParameter', '0', '1', '0', '1', 'cp.sig', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'CommonParameter', '0', '2', '0', '1', 'cp.v', 'String', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'Customer', '0', '0', '0', '1', 'c.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', '0', '0', '0', '1', 'edr.summary.total', 'Integer', '=', '1', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', '0', '1', '0', '1', 'edr.summary.start', 'Integer', '=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', '0', '2', '0', '1', 'edr.summary.returned', 'Integer', '=', 'edr.summary.total', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GetAddResponse', '0', '0', '0', '1', 'gar.summary.total', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GetAddResponse', '0', '1', '0', '1', 'gar.summary.start', 'Integer', '=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GetAddResponse', '0', '2', '0', '1', 'gar.summary.returned', 'Integer', '=', 'gar.summary.total', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GoGridRequest', '0', '0', '0', '1', 'gr.headerFields.header.H2String(gr.headerFields.header.Host)', 'String', '=', '\"//api.gogrid.com/api\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GoGridRequest', '0', '1', '0', '1', 'B2String(gr)', 'String', '=', 'gr.body', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', '0', '0', 'X.para.sig', 'String', '<>', 'sig_Re', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', '0', '1', 'G.List(X).status', 'String', '=', '403', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', '0', '0', 'sCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', '0', '1', 'res.summary.numpages', 'Integer', '=', 'res.summary.total/itemsPerPage', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', '0', '1', 'itemsPerPage', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '0', 'sCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '1', 'res.objects.items(i)', 'Server', '=', 'res.objects.items(j)', 'Server', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '1', 'sCode1', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '2', 'n', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '3', 'itemsPerPage1', 'Integer', '=', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '4', 'j', 'Integer', '=', '(k*n+i)', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '5', '0', 'Integer', '<=', 'i', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', '0', '6', 'i', 'Integer', '<', 'res.summary.returned', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', '0', '0', 'SCode', 'Integer', '==', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', '0', '1', 'NR', 'Integer', '<=', 'N', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', '0', '1', 'N', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', '0', '2', 'Pages', 'Integer', '==', 'NumPages', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', '0', '0', 'sCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', '0', '1', 'nr', 'Integer', '<=', 'n', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', '0', '1', 'n', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', '0', '2', 'lpage', 'Integer', '=', 'numPages', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', '0', '0', 'X2.name.length', 'ListofString', '=', '1', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', '0', '1', '[G.Add(X1)].Get(X2).objects', 'ListofServer', '=', 'G.Add(X1).objects', 'ListofServer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', '0', '1', 'X1.name', 'String', '=', 'X2.name.items(0)', 'ListofString', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', '0', '2', 'G.Add(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', '0', '3', '[G.Add(X1)].Get(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '1', '0', '0', 'search(X2.name,X1.name)', 'Boolean', '=', 'False', 'Bool', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '1', '0', '1', '[G.Add(X1)].Get(X2).objects', 'ListofServer', '=', 'G.Get(X2).objects', 'ListofServer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '1', '0', '1', 'G.Add(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '1', '0', '2', 'G.Get(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '2', '0', '0', 'search(X2.name,X1.name)', 'Boolean', '=', 'True', 'Bool', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '2', '0', '1', '[G.Delete(X1)].Get(X2).statusCode', 'Integer', '=', '500', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '2', '0', '1', 'G.Delete(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', '0', '0', 'search(X2.name,X1.name)', 'Boolean', '=', 'True', 'Bool', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', '0', '1', '[G.Delete(X1)].Get(X2).statusCode', 'Integer', '=', '500', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', '0', '1', 'G.Delete(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '1', '0', '0', 'search(X2.name,X1.name)', 'Boolean', '=', 'False', 'Bool', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '1', '0', '1', '[G.Delete(X1)].Get(X2).objects', 'ListofServer', '=', 'G.Get(X2).objects', 'ListofServer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '1', '0', '1', 'G.Delete(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '1', '0', '2', 'G.Get(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '2', '0', '0', 'search(X2.name,X1.name)', 'Boolean', '=', 'True', 'Bool', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '2', '0', '1', '[G.Delete(X1)].Get(X2).objects', 'ListofServer', '=', 'remove(G.Get(X2).objects,G.Delete(X1).objects)', 'ListofServer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '2', '0', '1', 'G.Get(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '2', '0', '2', 'G.Delete(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '2', '0', '3', '[G.Delete(X1)].Get(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '0', 'X1.name', 'String', '=', 'X2.name', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '1', 'G.Edit(X1).objects', 'ListofServer', '=', '[G.Delete(X2)].Add(X3).objects', 'ListofServer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '1', 'X3.name', 'String', '=', 'X1.name', 'String', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '2', 'G.Edit(X1).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '3', 'G.Delete(X2).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', '0', '4', '[G.Delete(X2)].Add(X3).statusCode', 'Integer', '=', '200', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'HTTPMethod', '0', '0', '0', '1', 'M2String(hm.PUT)', 'String', '=', '\"PUT\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'HTTPMethod', '0', '1', '0', '1', 'M2String(hm.POST)', 'String', '=', '\"POST\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'HTTPMethod', '0', '2', '0', '1', 'M2String(hm.GET)', 'String', '=', '\"GET\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'HTTPMethod', '0', '3', '0', '1', 'M2String(hm.DELETE)', 'String', '=', '\"DELETE\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'IPO', '0', '0', '0', '1', 'io.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListRequest', '0', '0', '0', '1', 'lr.num_items', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListRequest', '0', '1', '0', '0', 'lr.num_items', 'Integer', '>', '0', 'Integer', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListRequest', '0', '1', '0', '1', 'lr.page', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListResponse', '0', '0', '0', '1', 'lr.summary.total', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListResponse', '0', '1', '0', '1', 'lr.summary.start', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListResponse', '0', '2', '0', '1', 'lr.summary.returned', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ListResponse', '0', '3', '0', '1', 'lr.summary.numpages', 'Integer', '>=', '0', 'Integer', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'Option', '0', '0', '0', '1', 'o.id', 'Integer', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'RequestHeader', '0', '0', '0', '1', 'H2String(rh.Accept)', 'String', '=', '\"Accept\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'Server', '0', '0', '0', '1', 's.id', 'Long', '<>', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerAddResponse', '0', '0', '0', '1', 'sar.request_method', 'String', '=', '\"/grid/server/add\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '0', '0', '0', 'sdr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '0', '0', '1', 'sdr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '1', '0', '0', 'sdr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '1', '0', '1', 'sdr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '2', '0', '0', 'sdr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '2', '0', '1', 'sdr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '3', '0', '0', 'sdr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '3', '0', '1', 'sdr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '4', '0', '0', 'sdr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '4', '0', '1', 'sdr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '5', '0', '0', 'sdr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '5', '0', '1', 'sdr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteResponse', '0', '0', '0', '1', 'sdr.request_method', 'String', '=', '\"/grid/server/delete\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '0', '0', '0', 'ser.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '0', '0', '1', 'ser.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '1', '0', '0', 'ser.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '1', '0', '1', 'ser.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '2', '0', '0', 'ser.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '2', '0', '1', 'ser.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '3', '0', '0', 'ser.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '3', '0', '1', 'ser.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '4', '0', '0', 'ser.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '4', '0', '1', 'ser.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '5', '0', '0', 'ser.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '5', '0', '1', 'ser.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditResponse', '0', '0', '0', '1', 'ser.request_method', 'String', '=', '\"/grid/server/edit\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '0', '0', '0', 'sgr.id', 'ListofString', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '0', '0', '1', 'sgr.name', 'ListofString', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '1', '0', '0', 'sgr.id', 'ListofString', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '1', '0', '1', 'sgr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '2', '0', '0', 'sgr.name', 'ListofString', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '2', '0', '1', 'sgr.id', 'ListofString', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '3', '0', '0', 'sgr.name', 'ListofString', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '3', '0', '1', 'sgr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '4', '0', '0', 'sgr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '4', '0', '1', 'sgr.id', 'ListofString', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '5', '0', '0', 'sgr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '5', '0', '1', 'sgr.name', 'ListofString', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetResponse', '0', '0', '0', '1', 'sgr.request_method', 'String', '=', '\"/grid/server/get\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerListResponse', '0', '0', '0', '1', 'slr.request_method', 'String', '=', '\"/grid/server/list\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '0', '0', '0', 'spr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '0', '0', '1', 'spr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '1', '0', '0', 'spr.id', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '1', '0', '1', 'spr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '2', '0', '0', 'spr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '2', '0', '1', 'spr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '3', '0', '0', 'spr.name', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '3', '0', '1', 'spr.server', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '4', '0', '0', 'spr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '4', '0', '1', 'spr.id', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '5', '0', '0', 'spr.server', 'String', '<>', 'Null', 'Null', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '5', '0', '1', 'spr.name', 'String', '=', 'Null', 'Null', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerResponse', '0', '0', '0', '1', 'spr.request_method', 'String', '=', '\"/grid/server/power\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '0', '0', '1', 'url.Scheme', 'String', '=', '\"http\"', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '1', '0', '1', 'url.URL2MSG.server', 'String', '=', 'url.Host', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '2', '0', '1', 'url.URL2MSG.path', 'String', '=', 'url.Path', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '3', '0', '0', 'url.URL2MSG.method', 'HTTPMethod', '=', 'hm.GET', 'ConstOp', 'ifcondition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '3', '0', '1', 'rhf.HF2String(url.URL2MSG.headerFields)', 'String', '=', 'qs.QS2String(url.Query_string)', 'String', 'condition', null);
INSERT INTO `equation` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '4', '0', '0', 'url.URL2MSG.method', 'HTTPMethod', '=', 'hm.POST', 'ConstOp', 'ifcondition', null);
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PopResponse', '0', '0', '0', '0', 'por.success', 'Bool', '=', 'true', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PopResponse', '0', '0', '0', '1', 'por.message', 'String', '=', '\"pop success\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PopResponse', '0', '1', '0', '0', 'por.success', 'Bool', '=', 'false', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PopResponse', '0', '1', '0', '1', 'por.message', 'String', '=', '\"pop error\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PushResponse', '0', '0', '0', '0', 'pur.success', 'Bool', '=', 'true', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PushResponse', '0', '0', '0', '1', 'pur.message', 'String', '=', '\"push success\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PushResponse', '0', '1', '0', '0', 'pur.success', 'Bool', '=', 'false', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'PushResponse', '0', '1', '0', '1', 'pur.message', 'String', '=', '\"push error\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'ReplaceResponse', '0', '0', '0', '0', 'rr.success', 'Bool', '=', 'true', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'ReplaceResponse', '0', '0', '0', '1', 'rr.message', 'String', '=', '\"replace success\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'ReplaceResponse', '0', '1', '0', '0', 'rr.success', 'Bool', '=', 'false', 'Bool', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'ReplaceResponse', '0', '1', '0', '1', 'rr.message', 'String', '=', '\"replace error\"', 'String', 'condition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', '0', '0', 's.length', 'Integer', '>', '1', 'Integer', 'ifcondition', '');
INSERT INTO `equation` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', '0', '1', '[pushres.replace(y)].top', 'Integer', '=', '[s.push(y)].top', 'Integer', 'condition', '');

-- ----------------------------
-- Table structure for `opdomain`
-- ----------------------------
DROP TABLE IF EXISTS `opdomain`;
CREATE TABLE `opdomain` (
  `OpID` varchar(50) NOT NULL,
  `SID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `SpecID` varchar(50) NOT NULL,
  `Flag` varchar(50) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `DomainIndex` int(11) NOT NULL,
  PRIMARY KEY (`OpID`,`SID`,`SubSpecID`,`SpecID`,`Flag`,`Type`,`DomainIndex`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of opdomain
-- ----------------------------
INSERT INTO `opdomain` VALUES ('abs', 'Definition', 'GoGrid.asoc', 'GogridTest', 'codomain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('abs', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('Add', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerAddResponse', '0');
INSERT INTO `opdomain` VALUES ('Add', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerAddRequest', '0');
INSERT INTO `opdomain` VALUES ('Delete', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerDeleteResponse', '0');
INSERT INTO `opdomain` VALUES ('Delete', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerDeleteRequest', '0');
INSERT INTO `opdomain` VALUES ('Edit', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerEditResponse', '0');
INSERT INTO `opdomain` VALUES ('Edit', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerEditRequest', '0');
INSERT INTO `opdomain` VALUES ('Get', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerGetResponse', '0');
INSERT INTO `opdomain` VALUES ('Get', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerGetRequest', '0');
INSERT INTO `opdomain` VALUES ('insert', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ListofIPPP', '0');
INSERT INTO `opdomain` VALUES ('insert', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'domain', 'IPPP', '1');
INSERT INTO `opdomain` VALUES ('insert', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'domain', 'ListofIPPP', '0');
INSERT INTO `opdomain` VALUES ('insert', 'ListofServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ListofServer', '0');
INSERT INTO `opdomain` VALUES ('insert', 'ListofServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'Server', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofBillingToken', 'GoGrid.asoc', 'GogridTest', 'codomain', 'BillingToken', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofBillingToken', 'GoGrid.asoc', 'GogridTest', 'domain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'codomain', 'IPPP', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'domain', 'Integer', '1');
INSERT INTO `opdomain` VALUES ('items', 'ListofIPPP', 'GoGrid.asoc', 'GogridTest', 'domain', 'ListofIPPP', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'Server', '0');
INSERT INTO `opdomain` VALUES ('items', 'ListofServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('List', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerListResponse', '0');
INSERT INTO `opdomain` VALUES ('List', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerListRequest', '0');
INSERT INTO `opdomain` VALUES ('MD5', 'Definition', 'GoGrid.asoc', 'GogridTest', 'codomain', 'String', '0');
INSERT INTO `opdomain` VALUES ('MD5', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'Integer', '2');
INSERT INTO `opdomain` VALUES ('MD5', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'String', '0');
INSERT INTO `opdomain` VALUES ('MD5', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'String', '1');
INSERT INTO `opdomain` VALUES ('pop', 'StackService', 'StackS.txt', 'StackSs', 'codomain', 'PopResponse', '0');
INSERT INTO `opdomain` VALUES ('pop', 'StackService', 'StackS.txt', 'StackSs', 'domain', 'void', '0');
INSERT INTO `opdomain` VALUES ('Power', 'GServer', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ServerPowerResponse', '0');
INSERT INTO `opdomain` VALUES ('Power', 'GServer', 'GoGrid.asoc', 'GogridTest', 'domain', 'ServerPowerRequest', '0');
INSERT INTO `opdomain` VALUES ('push', 'StackService', 'StackS.txt', 'StackSs', 'codomain', 'PushResponse', '0');
INSERT INTO `opdomain` VALUES ('push', 'StackService', 'StackS.txt', 'StackSs', 'domain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('remove', 'Definition', 'GoGrid.asoc', 'GogridTest', 'codomain', 'ListofServer', '0');
INSERT INTO `opdomain` VALUES ('remove', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'ListofServer', '0');
INSERT INTO `opdomain` VALUES ('remove', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'ListofServer', '1');
INSERT INTO `opdomain` VALUES ('replace', 'StackService', 'StackS.txt', 'StackSs', 'codomain', 'ReplaceResponse', '0');
INSERT INTO `opdomain` VALUES ('replace', 'StackService', 'StackS.txt', 'StackSs', 'domain', 'Integer', '0');
INSERT INTO `opdomain` VALUES ('search', 'Definition', 'GoGrid.asoc', 'GogridTest', 'codomain', 'Boolean', '0');
INSERT INTO `opdomain` VALUES ('search', 'Definition', 'GoGrid.asoc', 'GogridTest', 'domain', 'String', '0');

-- ----------------------------
-- Table structure for `operations`
-- ----------------------------
DROP TABLE IF EXISTS `operations`;
CREATE TABLE `operations` (
  `id` int(11) NOT NULL,
  `optname` varchar(255) NOT NULL,
  `opttype` varchar(255) NOT NULL,
  `optinput` varchar(255) DEFAULT NULL,
  `optoutput` varchar(255) NOT NULL,
  `optbelong` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of operations
-- ----------------------------
INSERT INTO `operations` VALUES ('0', '0', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('1', '1', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('2', '2', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('3', '3', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('4', '4', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('5', '5', 'constant', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('6', 'true', 'constant', null, 'Bool', 'Bool');
INSERT INTO `operations` VALUES ('7', 'false', 'constant', null, 'Bool', 'Bool');
INSERT INTO `operations` VALUES ('8', 'nil', 'constant', null, 'Stack', 'Stack');
INSERT INTO `operations` VALUES ('9', 'x', 'variable', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('10', 'y', 'variable', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('11', 'z', 'variable', null, 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('12', 's', 'variable', null, 'Stack', 'Stack');
INSERT INTO `operations` VALUES ('13', 'isEmpty', 'attr', 'Stack', 'Bool', 'Stack');
INSERT INTO `operations` VALUES ('14', 'length', 'attr', 'Stack', 'Integer', 'Stack');
INSERT INTO `operations` VALUES ('15', 'top', 'attr', 'Stack', 'Integer', 'Stack');
INSERT INTO `operations` VALUES ('16', 'max', 'attr', 'Stack', 'Integer', 'Stack');
INSERT INTO `operations` VALUES ('17', 'push', 'trans', 'Stack', 'Stack', 'Stack');
INSERT INTO `operations` VALUES ('18', 'pop', 'trans', 'Stack', 'Stack', 'Stack');
INSERT INTO `operations` VALUES ('19', 'replace', 'trans', 'Stack,Integer', 'Stack', 'Stack');
INSERT INTO `operations` VALUES ('20', 'isEq', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('21', 'isG', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('22', 'isL', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('23', 'isGEq', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('24', 'isLEq', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('25', 'isNEq', 'retri', 'Integer,Integer', 'Bool', 'Integer');
INSERT INTO `operations` VALUES ('26', 'AssertTrue', 'retri', 'Bool', 'Stack', 'Bool');
INSERT INTO `operations` VALUES ('27', 'add', 'retri', 'Integer,Integer', 'Integer', 'Integer');
INSERT INTO `operations` VALUES ('28', 'st', 'variable', null, 'Stack', 'Stack');

-- ----------------------------
-- Table structure for `operator`
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `SID` varchar(50) NOT NULL,
  `SpecID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `OpID` varchar(50) NOT NULL,
  `Flag` varchar(50) DEFAULT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `OpIndex` varchar(50) DEFAULT NULL,
  `isChangeState` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SID`,`SpecID`,`SubSpecID`,`OpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('AddRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('AddRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('AddRequest', 'GogridTest', 'GoGrid.asoc', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('AddRequest', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'endDate', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'endTimestamp', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryAccrued', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryAllotment', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryInUse', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryOverage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryProjectedOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryProjectedTotalCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'memoryProjectedUsage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'startDate', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'startTimestamp', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferAccrued', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferAllotment', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferOverage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferProjectedOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferProjectedTotalCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'transferProjectedUsage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'endDate', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'endTimestamp', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryAccrued', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryAllotment', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryInUse', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryOverage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryProjectedOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryProjectedTotalCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'memoryProjectedUsage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'startDate', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'startTimestamp', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferAccrued', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferAllotment', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferOverage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferProjectedOverageCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferProjectedTotalCharge', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'transferProjectedUsage', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'api_Key', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'format', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'sig', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'v', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GogridTest', 'GoGrid.asoc', 'api_Key', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GogridTest', 'GoGrid.asoc', 'format', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GogridTest', 'GoGrid.asoc', 'sig', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('CommonParameter', 'GogridTest', 'GoGrid.asoc', 'v', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Customer', 'GoGrid-v2', 'Option.as', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('Customer', 'GoGrid-v2', 'Option.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Customer', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('Customer', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'abs', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'MD5', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'remove', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'search', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('DeleteRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'id', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('DeleteRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('DeleteRequest', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('DeleteRequest', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'id', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GogridTest', 'GoGrid.asoc', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('EditRequest', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GetRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'id', 'attribute', 'String', '*', null);
INSERT INTO `operator` VALUES ('GetRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'name', 'attribute', 'String', '*', null);
INSERT INTO `operator` VALUES ('GetRequest', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'ListofString', '', null);
INSERT INTO `operator` VALUES ('GetRequest', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'ListofString', '', null);
INSERT INTO `operator` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'B2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'para', 'attribute', 'CommonParameter', '', null);
INSERT INTO `operator` VALUES ('GoGridRequest', 'GogridTest', 'GoGrid.asoc', 'B2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridRequest', 'GogridTest', 'GoGrid.asoc', 'para', 'attribute', 'CommonParameter', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'B2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'request_method', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'status', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'statusCode', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'summary', 'attribute', 'ResponseSummary', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'B2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'request_method', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'status', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'statusCode', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'summary', 'attribute', 'ResponseSummary', '', null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'Add', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'clockTime', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'Delete', 'general', 'NULL', null, '1');
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'Edit', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'Get', 'general', 'NULL', null, '0');
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'List', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'Power', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'sharedSecrte', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'timeStamp', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'DELETE', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'GET', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'HM2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'POST', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'PUT', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'DELETE', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'GET', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'M2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'POST', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'PUT', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'headerFields', 'attribute', 'RequestHeaderField', '1..*', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'method', 'attribute', 'HTTPMethod', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'server', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'headerFields', 'attribute', 'RequestHeaderField', '1..*', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'method', 'attribute', 'HTTPMethod', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'server', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'code', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'headerFields', 'attribute', 'ResponseHeaderField', '0..*', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GogridTest', 'GoGrid.asoc', 'body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GogridTest', 'GoGrid.asoc', 'code', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('HTTPResponse', 'GogridTest', 'GoGrid.asoc', 'headerFields', 'attribute', 'ResponseHeaderField', '0..*', null);
INSERT INTO `operator` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'ip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'public', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'subnet', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'ip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'public', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'subnet', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('IPPP', 'GoGrid-v2', 'Option.as', 'ip', 'attribute', 'IPO', '', null);
INSERT INTO `operator` VALUES ('IPPP', 'GoGrid-v2', 'Option.as', 'port', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('IPPP', 'GogridTest', 'GoGrid.asoc', 'ip', 'attribute', 'IPO', '', null);
INSERT INTO `operator` VALUES ('IPPP', 'GogridTest', 'GoGrid.asoc', 'port', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListofBillingToken', 'GogridTest', 'GoGrid.asoc', 'items', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ListofIPPP', 'GogridTest', 'GoGrid.asoc', 'insert', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ListofIPPP', 'GogridTest', 'GoGrid.asoc', 'items', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ListofIPPP', 'GogridTest', 'GoGrid.asoc', 'length', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListofServer', 'GogridTest', 'GoGrid.asoc', 'insert', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ListofServer', 'GogridTest', 'GoGrid.asoc', 'items', 'general', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ListofServer', 'GogridTest', 'GoGrid.asoc', 'length', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'num_items', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'page', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListRequest', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ListRequest', 'GogridTest', 'GoGrid.asoc', 'num_items', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ListRequest', 'GogridTest', 'GoGrid.asoc', 'page', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'id', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Option', 'GogridTest', 'GoGrid.asoc', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Option', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('Option', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'message', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'operations', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'status', 'attribute', 'StatusInfo', '', '');
INSERT INTO `operator` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'success', 'attribute', 'Bool', '', '');
INSERT INTO `operator` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'message', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'operations', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'status', 'attribute', 'StatusInfo', '', '');
INSERT INTO `operator` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'success', 'attribute', 'Bool', '', '');
INSERT INTO `operator` VALUES ('QueryParameter', 'GoGrid-v2', 'HTTPFramework.as', 'header', 'attribute', 'RequestHeader', '', null);
INSERT INTO `operator` VALUES ('QueryParameter', 'GoGrid-v2', 'HTTPFramework.as', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('QueryParameter', 'GogridTest', 'GoGrid.asoc', 'header', 'attribute', 'RequestHeader', '', null);
INSERT INTO `operator` VALUES ('QueryParameter', 'GogridTest', 'GoGrid.asoc', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'para', 'attribute', 'QueryParameter', '1..*', null);
INSERT INTO `operator` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'QS2Body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'QS2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('QueryString', 'GogridTest', 'GoGrid.asoc', 'para', 'attribute', 'QueryParameter', '1..*', null);
INSERT INTO `operator` VALUES ('QueryString', 'GogridTest', 'GoGrid.asoc', 'QS2Body', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('QueryString', 'GogridTest', 'GoGrid.asoc', 'QS2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'message', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'operations', 'attribute', 'String', '', '');
INSERT INTO `operator` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'status', 'attribute', 'StatusInfo', '', '');
INSERT INTO `operator` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'success', 'attribute', 'Bool', '', '');
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Accept', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Accept_Encoding', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Date', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Host', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'If_Modified_Since', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'If_None_Match', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'RH2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'User_Agent', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'Accept', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'Accept_Encoding', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'Date', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'H2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'Host', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'If_Modified_Since', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'If_None_Match', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'User_Agent', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'header', 'attribute', 'RequestHeader', '', null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'RHF2Str', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GogridTest', 'GoGrid.asoc', 'header', 'attribute', 'RequestHeader', '', null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GogridTest', 'GoGrid.asoc', 'HF2String', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('RequestHeaderField', 'GogridTest', 'GoGrid.asoc', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Age', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Content_Encoding', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Content_Length', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Content_Type', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Date', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'ETag', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Last_Modified', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'Location', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'WWW_Authenticate', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Age', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Content_Encoding', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Content_Length', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Content_Type', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Date', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'ETag', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Last_Modified', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'Location', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'WWW_Authenticate', 'constant', 'NULL', null, null);
INSERT INTO `operator` VALUES ('ResponseHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'header', 'attribute', 'ResponseHeader', '', null);
INSERT INTO `operator` VALUES ('ResponseHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ResponseHeaderField', 'GogridTest', 'GoGrid.asoc', 'header', 'attribute', 'ResponseHeader', '', null);
INSERT INTO `operator` VALUES ('ResponseHeaderField', 'GogridTest', 'GoGrid.asoc', 'value', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'numpages', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'returned', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'start', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'total', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GogridTest', 'GoGrid.asoc', 'numpages', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GogridTest', 'GoGrid.asoc', 'returned', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GogridTest', 'GoGrid.asoc', 'start', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ResponseSummary', 'GogridTest', 'GoGrid.asoc', 'total', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'datacenter', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'image', 'attribute', 'ServerImage', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'ip', 'attribute', 'IPO', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'os', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'ram', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'type', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'datacenter', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'Long', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'image', 'attribute', 'ServerImage', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'ip', 'attribute', 'IPO', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'os', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'ram', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'type', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'image', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'ip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'privateip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'server_ram', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'image', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'ip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'privateip', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'server_ram', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerAddResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerAddResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('ServerDeleteRequest', 'GoGrid-v2', 'Server.as', 'server', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerDeleteResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'server', 'attribute', 'String', '*', null);
INSERT INTO `operator` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'server_ram', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'server_type', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerEditRequest', 'GogridTest', 'GoGrid.asoc', 'server_ram', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerEditRequest', 'GogridTest', 'GoGrid.asoc', 'server_type', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerEditResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerEditResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('ServerGetRequest', 'GoGrid-v2', 'Server.as', 'server', 'attribute', 'String', '*', null);
INSERT INTO `operator` VALUES ('ServerGetResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerGetResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'architecture', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'billingTokens', 'attribute', 'BillingToken', '*', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'createdTime', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'friendlyName', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'gsitype', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'id', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'isActive', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'isPublic', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'location', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'minram', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'os', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'owner', 'attribute', 'Customer', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'price', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'type', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'updatedTime', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'architecture', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'billingTokens', 'attribute', 'ListofBillingToken', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'createdTime', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'description', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'friendlyName', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'gsitype', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'id', 'attribute', 'Integer', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'isActive', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'isPublic', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'location', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'minram', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'name', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'os', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'owner', 'attribute', 'Customer', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'price', 'attribute', 'Double', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'state', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'type', 'attribute', 'Option', '', null);
INSERT INTO `operator` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'updatedTime', 'attribute', 'Datetime', '', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'datacenter', 'attribute', 'String', '*', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'server_type', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'datacentre', 'attribute', 'ListofString', '', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'isSandbox', 'attribute', 'Boolean', '', null);
INSERT INTO `operator` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'server_type', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerListResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerListResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('ServerPowerRequest', 'GoGrid-v2', 'Server.as', 'power', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerPowerRequest', 'GoGrid-v2', 'Server.as', 'server', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerPowerRequest', 'GogridTest', 'GoGrid.asoc', 'power', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('ServerPowerResponse', 'GoGrid-v2', 'Server.as', 'Objects', 'attribute', 'Server', '*', null);
INSERT INTO `operator` VALUES ('ServerPowerResponse', 'GogridTest', 'GoGrid.asoc', 'objects', 'attribute', 'ListofServer', '', null);
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'isEmpty', 'attribute', 'Bool', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'length', 'attribute', 'Integer', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'nil', 'constant', 'NULL', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'pop', 'general', 'NULL', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'push', 'general', 'NULL', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'replace', 'general', 'NULL', '', '');
INSERT INTO `operator` VALUES ('StackService', 'StackSs', 'StackS.txt', 'top', 'attribute', 'Integer', '', '');
INSERT INTO `operator` VALUES ('StatusInfo', 'StackSs', 'StackS.txt', 'isEmpty', 'attribute', 'Bool', '', '');
INSERT INTO `operator` VALUES ('StatusInfo', 'StackSs', 'StackS.txt', 'length', 'attribute', 'Integer', '', '');
INSERT INTO `operator` VALUES ('URL', '2015', 'GoGrid.as', 'Scheme', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', '2015', 'GoGrid.as', 'URL2MSG', 'attribute', 'HTTPRequest', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'Host', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'Path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'Port_num', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'Query_string', 'attribute', 'QueryString', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'Scheme', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'GoGrid', 'URL2MSG', 'attribute', 'HTTPRequest', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'Host', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'Path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'Port_num', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'Query_string', 'attribute', 'QueryString', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'Scheme', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid', 'HTTP Framework.as', 'URL2MSG', 'attribute', 'HTTPRequest', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Host', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Port_num', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Query_string', 'attribute', 'QueryString', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Scheme', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'URL2MSG', 'attribute', 'HTTPRequest', '', null);
INSERT INTO `operator` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'Host', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'Path', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'Port_num', 'attribute', 'String', '', null);
INSERT INTO `operator` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'Query_string', 'attribute', 'QueryString', '', null);
INSERT INTO `operator` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'Scheme', 'attribute', 'String', '', null);

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `SID` varchar(50) NOT NULL,
  `SpecID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `ObserveOpID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SID`,`SpecID`,`SubSpecID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('AddRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('AddRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('BillingToken', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('CommonParameter', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('Customer', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('Customer', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('DeleteRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('DeleteRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('EditDeleteResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('EditDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('EditRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('GetAddResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('GetAddResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('GetRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('GetRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('GoGridRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('HTTPMethod', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('HTTPResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('IPPP', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('IPPP', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ListofBillingToken', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ListofIPPP', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ListofServer', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ListRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('ListRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ListResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('ListResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('Option', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'null');
INSERT INTO `sort` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'null');
INSERT INTO `sort` VALUES ('QueryParameter', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('QueryParameter', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('QueryString', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'null');
INSERT INTO `sort` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('RequestHeader', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('RequestHeaderField', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ResponseHeader', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('ResponseHeader', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ResponseHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'null');
INSERT INTO `sort` VALUES ('ResponseHeaderField', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'null');
INSERT INTO `sort` VALUES ('ResponseSummary', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerAddResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerAddResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerDeleteRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerDeleteRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerDeleteResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerEditRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerEditResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerEditResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerGetRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerGetRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerGetResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerGetResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'null');
INSERT INTO `sort` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerListResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerListResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerPowerRequest', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerPowerRequest', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('ServerPowerResponse', 'GoGrid-v2', 'Server.as', 'null');
INSERT INTO `sort` VALUES ('ServerPowerResponse', 'GogridTest', 'GoGrid.asoc', 'null');
INSERT INTO `sort` VALUES ('StackService', 'StackSs', 'StackS.txt', 'null');
INSERT INTO `sort` VALUES ('StatusInfo', 'StackSs', 'StackS.txt', 'null');
INSERT INTO `sort` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'null');

-- ----------------------------
-- Table structure for `sortrelation`
-- ----------------------------
DROP TABLE IF EXISTS `sortrelation`;
CREATE TABLE `sortrelation` (
  `SID` varchar(50) NOT NULL,
  `SpecID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `RelatedSID` varchar(50) NOT NULL,
  `Flag` varchar(10) NOT NULL,
  PRIMARY KEY (`SID`,`SpecID`,`SubSpecID`,`RelatedSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sortrelation
-- ----------------------------
INSERT INTO `sortrelation` VALUES ('AddRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('AddRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('AddRequest', 'GogridTest', 'GoGrid.asoc', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'Datetime', 'uses');
INSERT INTO `sortrelation` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'Double', 'uses');
INSERT INTO `sortrelation` VALUES ('BillingToken', 'GoGrid-v2', 'Option.as', 'Long', 'uses');
INSERT INTO `sortrelation` VALUES ('CommonParameter', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('Customer', 'GoGrid-v2', 'Option.as', 'Long', 'uses');
INSERT INTO `sortrelation` VALUES ('Customer', 'GoGrid-v2', 'Option.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('Definition', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('DeleteRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('DeleteRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('DeleteRequest', 'GogridTest', 'GoGrid.asoc', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('EditDeleteResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('EditDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('EditRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('EditRequest', 'GogridTest', 'GoGrid.asoc', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('GetAddResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('GetAddResponse', 'GogridTest', 'GoGrid.asoc', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('GetRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('GetRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('GetRequest', 'GogridTest', 'GoGrid.asoc', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('GetRequest', 'GogridTest', 'GoGrid.asoc', 'ListofString', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'CommonParameter', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'HTTPRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('GoGridRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridRequest', 'GogridTest', 'GoGrid.asoc', 'CommonParameter', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridRequest', 'GogridTest', 'GoGrid.asoc', 'HTTPRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'HTTPResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ResponseSummary', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'HTTPResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('GoGridResponse', 'GogridTest', 'GoGrid.asoc', 'ResponseSummary', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerAddRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerAddResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerDeleteResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerEditRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerEditResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerGetRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerGetResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerListRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerListResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('GServer', 'GogridTest', 'GoGrid.asoc', 'ServerPowerResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPMethod', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'HTTPMethod', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'RequestHeaderField', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPRequest', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'HTTPMethod', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPRequest', 'GogridTest', 'GoGrid.asoc', 'RequestHeaderField', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'ResponseHeaderField', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPResponse', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('HTTPResponse', 'GogridTest', 'GoGrid.asoc', 'ResponseHeaderField', 'uses');
INSERT INTO `sortrelation` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'Boolean', 'uses');
INSERT INTO `sortrelation` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'Long', 'uses');
INSERT INTO `sortrelation` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('IPO', 'GoGrid-v2', 'Option.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('IPO', 'GogridTest', 'GoGrid.asoc', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('IPPP', 'GoGrid-v2', 'Option.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('IPPP', 'GoGrid-v2', 'Option.as', 'IPO', 'uses');
INSERT INTO `sortrelation` VALUES ('IPPP', 'GogridTest', 'GoGrid.asoc', 'IPO', 'uses');
INSERT INTO `sortrelation` VALUES ('ListofBillingToken', 'GogridTest', 'GoGrid.asoc', 'BillingToken', 'uses');
INSERT INTO `sortrelation` VALUES ('ListofIPPP', 'GogridTest', 'GoGrid.asoc', 'IPPP', 'uses');
INSERT INTO `sortrelation` VALUES ('ListofServer', 'GogridTest', 'GoGrid.asoc', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ListRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ListRequest', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('ListRequest', 'GogridTest', 'GoGrid.asoc', 'GoGridRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ListResponse', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ListResponse', 'GogridTest', 'GoGrid.asoc', 'GoGridResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('Option', 'GoGrid-v2', 'Option.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'Bool', 'uses');
INSERT INTO `sortrelation` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'StatusInfo', 'uses');
INSERT INTO `sortrelation` VALUES ('PopResponse', 'StackSs', 'StackS.txt', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'Bool', 'uses');
INSERT INTO `sortrelation` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'StatusInfo', 'uses');
INSERT INTO `sortrelation` VALUES ('PushResponse', 'StackSs', 'StackS.txt', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryParameter', 'GoGrid-v2', 'HTTPFramework.as', 'RequestHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryParameter', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryParameter', 'GogridTest', 'GoGrid.asoc', 'RequestHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'QueryParameter', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryString', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('QueryString', 'GogridTest', 'GoGrid.asoc', 'QueryParameter', 'uses');
INSERT INTO `sortrelation` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'Bool', 'uses');
INSERT INTO `sortrelation` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'StatusInfo', 'uses');
INSERT INTO `sortrelation` VALUES ('ReplaceResponse', 'StackSs', 'StackS.txt', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('RequestHeader', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'RequestHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('RequestHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('RequestHeaderField', 'GogridTest', 'GoGrid.asoc', 'RequestHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('ResponseHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'ResponseHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('ResponseHeaderField', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ResponseHeaderField', 'GogridTest', 'GoGrid.asoc', 'ResponseHeader', 'uses');
INSERT INTO `sortrelation` VALUES ('ResponseSummary', 'GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'Boolean', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'IPO', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'Long', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'ServerImage', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GoGrid-v2', 'Option.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'IPO', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('Server', 'GogridTest', 'GoGrid.asoc', 'ServerImage', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'AddRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'Boolean', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerAddRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'AddRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerAddRequest', 'GogridTest', 'GoGrid.asoc', 'ListofString', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerAddResponse', 'GoGrid-v2', 'Server.as', 'GetAddResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerAddResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerAddResponse', 'GogridTest', 'GoGrid.asoc', 'GetAddResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerAddResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerDeleteRequest', 'GoGrid-v2', 'Server.as', 'DeleteRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerDeleteRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerDeleteRequest', 'GogridTest', 'GoGrid.asoc', 'DeleteRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerDeleteResponse', 'GoGrid-v2', 'Server.as', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerDeleteResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerDeleteResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'EditRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerEditRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerEditRequest', 'GogridTest', 'GoGrid.asoc', 'EditRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerEditResponse', 'GoGrid-v2', 'Server.as', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerEditResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerEditResponse', 'GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerEditResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerGetRequest', 'GoGrid-v2', 'Server.as', 'GetRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerGetRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerGetRequest', 'GogridTest', 'GoGrid.asoc', 'GetRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerGetResponse', 'GoGrid-v2', 'Server.as', 'GetResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerGetResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerGetResponse', 'GogridTest', 'GoGrid.asoc', 'GetAddResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerGetResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'BillingToken', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'Boolean', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'Customer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'DateTime', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'Double', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GoGrid-v2', 'Option.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'Customer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'ListofBillingToken', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerImage', 'GogridTest', 'GoGrid.asoc', 'Option', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'Boolean', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'ListRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerListRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'ListofString', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListRequest', 'GogridTest', 'GoGrid.asoc', 'ListRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerListResponse', 'GoGrid-v2', 'Server.as', 'ListResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerListResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerListResponse', 'GogridTest', 'GoGrid.asoc', 'ListResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerPowerRequest', 'GoGrid-v2', 'Server.as', 'DeleteRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerPowerRequest', 'GoGrid-v2', 'Server.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerPowerRequest', 'GogridTest', 'GoGrid.asoc', 'DeleteRequest', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerPowerResponse', 'GoGrid-v2', 'Server.as', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerPowerResponse', 'GoGrid-v2', 'Server.as', 'Server', 'uses');
INSERT INTO `sortrelation` VALUES ('ServerPowerResponse', 'GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', 'extends');
INSERT INTO `sortrelation` VALUES ('ServerPowerResponse', 'GogridTest', 'GoGrid.asoc', 'ListofServer', 'uses');
INSERT INTO `sortrelation` VALUES ('StackService', 'StackSs', 'StackS.txt', 'Bool', 'uses');
INSERT INTO `sortrelation` VALUES ('StackService', 'StackSs', 'StackS.txt', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('StackService', 'StackSs', 'StackS.txt', 'PopResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('StackService', 'StackSs', 'StackS.txt', 'PushResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('StackService', 'StackSs', 'StackS.txt', 'ReplaceResponse', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'HTTPRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'Integer', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'QueryString', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GoGrid-v2', 'HTTPFramework.as', 'String', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'HTTPMethod', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'HTTPRequest', 'uses');
INSERT INTO `sortrelation` VALUES ('URL', 'GogridTest', 'GoGrid.asoc', 'QueryString', 'uses');

-- ----------------------------
-- Table structure for `spec`
-- ----------------------------
DROP TABLE IF EXISTS `spec`;
CREATE TABLE `spec` (
  `SpecID` varchar(250) NOT NULL,
  `username` varchar(250) NOT NULL,
  PRIMARY KEY (`SpecID`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spec
-- ----------------------------
INSERT INTO `spec` VALUES ('Gogrid', 'Chen');
INSERT INTO `spec` VALUES ('guiyue', 'muyi');
INSERT INTO `spec` VALUES ('haode', 'muyi');
INSERT INTO `spec` VALUES ('StackSs', 'zx');
INSERT INTO `spec` VALUES ('zl', 'zx');
INSERT INTO `spec` VALUES ('zx', 'zx');

-- ----------------------------
-- Table structure for `specification`
-- ----------------------------
DROP TABLE IF EXISTS `specification`;
CREATE TABLE `specification` (
  `subSpec` varchar(250) DEFAULT NULL,
  `SpecID` char(50) NOT NULL,
  `filePath` char(100) NOT NULL,
  `username` char(50) DEFAULT NULL,
  PRIMARY KEY (`filePath`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of specification
-- ----------------------------

-- ----------------------------
-- Table structure for `termiterm`
-- ----------------------------
DROP TABLE IF EXISTS `termiterm`;
CREATE TABLE `termiterm` (
  `term` varchar(255) NOT NULL,
  `iterm` varchar(255) NOT NULL,
  `belong` varchar(255) NOT NULL,
  PRIMARY KEY (`term`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of termiterm
-- ----------------------------
INSERT INTO `termiterm` VALUES ('pop(pop(push(st,1)))', 'push(pop(pop(push(st,1))),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('pop(replace(st,1))', 'push(pop(replace(st,1)),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('pop(st)', 'push(pop(st),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('push(pop(st),1)', 'replace(push(pop(st),1),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('push(st,2)', 'pop(push(st,2))', 'Stack');
INSERT INTO `termiterm` VALUES ('replace(pop(push(st,1)),2)', 'replace(replace(pop(push(st,1)),2),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('replace(push(pop(st),1),2)', 'replace(replace(push(pop(st),1),2),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('replace(push(st,1),2)', 'pop(replace(push(st,1),2))', 'Stack');
INSERT INTO `termiterm` VALUES ('replace(st,1)', 'replace(replace(st,1),top(st))', 'Stack');
INSERT INTO `termiterm` VALUES ('replace(st,2)', 'replace(replace(st,2),top(st))', 'Stack');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', 'zhangsan');

-- ----------------------------
-- Table structure for `variable`
-- ----------------------------
DROP TABLE IF EXISTS `variable`;
CREATE TABLE `variable` (
  `SpecID` varchar(50) NOT NULL,
  `SubSpecID` varchar(50) NOT NULL,
  `SID` varchar(50) NOT NULL,
  `AxIndex` int(11) NOT NULL,
  `EqIndex` int(11) NOT NULL,
  `VarID` varchar(50) NOT NULL,
  `Type` varchar(50) DEFAULT NULL,
  `Term` varchar(50) DEFAULT NULL,
  `Flag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SpecID`,`SubSpecID`,`SID`,`AxIndex`,`VarID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of variable
-- ----------------------------
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'AddRequest', '0', '0', 'ar', 'AddRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'CommonParameter', '0', '0', 'cp', 'CommonParameter', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'EditDeleteResponse', '0', '0', 'edr', 'EditDeleteResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GetAddResponse', '0', '0', 'gar', 'GetAddResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', '0', '0', 'gr', 'GoGridRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridRequest', '0', '0', 'i', 'Integer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'GoGridResponse', '0', '0', 'gr', 'GoGridResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListRequest', '0', '0', 'lr', 'ListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Common Requests and Responses of GoGrid.as', 'ListResponse', '0', '0', 'lr', 'ListResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '0', 'hr', 'HTTPRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '0', 'i', 'Integer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'HTTPFramework.as', 'URL', '0', '0', 'url', 'URL', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Option.as', 'Customer', '0', '0', 'c', 'Customer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Option.as', 'IPO', '0', '0', 'io', 'IPO', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Option.as', 'Option', '0', '0', 'o', 'Option', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Option.as', 'Server', '0', '0', 's', 'Server', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerAddResponse', '0', '0', 'sar', 'ServerAddResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteRequest', '0', '0', 'sdr', 'ServerDeleteRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerDeleteResponse', '0', '0', 'sdr', 'ServerDeleteResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditRequest', '0', '0', 'ser', 'ServerEditRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerEditResponse', '0', '0', 'ser', 'ServerEditResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetRequest', '0', '0', 'gr', 'ServerGetRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerGetResponse', '0', '0', 'sgr', 'ServerGetResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerListResponse', '0', '0', 'slr', 'ServerListResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerRequest', '0', '0', 'spr', 'ServerPowerRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GoGrid-v2', 'Server.as', 'ServerPowerResponse', '0', '0', 'spr', 'ServerPowerResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'AddRequest', '0', '0', 'ar', 'AddRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'CommonParameter', '0', '0', 'cp', 'CommonParameter', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'Customer', '0', '0', 'c', 'Customer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'EditDeleteResponse', '0', '0', 'edr', 'EditDeleteResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GetAddResponse', '0', '0', 'gar', 'GetAddResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GoGridRequest', '0', '0', 'gr', 'GoGridRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', 'key', 'String', 'X.para.api_Key', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', 'sig_Re', 'String', 'MD5(key,G.sharedSecret,G.timeStamp)', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '0', '0', 'X', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', 'itemsPerPage', 'Integer', 'X.num_items', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', 'res', 'ServerListResponse', 'G.List(X)', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', 'sCode', 'Integer', 'G.List(X).statusCode', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '1', '0', 'X', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'i', 'Integer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'itemsPerPage1', 'Integer', 'X1.num_items', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'j', 'Integer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'k', 'Integer', 'X.page', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'n', 'Integer', 'X.num_items', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'res', 'ServerListResponse', 'G.List(X)', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'res1', 'ServerListResponse', 'G.List(X1)', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'sCode', 'Integer', 'G.List(X).statusCode', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'sCode1', 'Integer', 'G.List(X1).statusCode', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'X', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '2', '0', 'X1', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'N', 'Integer', 'X.num_items', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'NR', 'Integer', 'G.List(X).summary.returned', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'NumPages', 'Integer', 'G.List(X).summary.numpages', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'Pages', 'Integer', 'X.page', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'Result', 'ListofServer', 'G.List(X).objects', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'SCode', 'Integer', 'G.List(X).statusCode', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '3', '0', 'X', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'lpage', 'Integer', 'X.page', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'n', 'Integer', 'X.num_items', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'nr', 'Integer', 'G.List(X).summary.returned', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'numPages', 'Integer', 'G.List(X).summary.numpages', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'result', 'ListofServer', 'G.List(X).objects', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'sCode', 'Integer', 'G.List(X).statusCode', 'Local');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '4', '0', 'X', 'ServerListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', 'i', 'Int', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', 'X1', 'ServerAddRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '5', '0', 'X2', 'ServerGetRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', 'X1', 'ServerDeleteRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '6', '0', 'X2', 'ServerGetRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', 'G', 'GServer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', 'X1', 'ServerEditRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', 'X2', 'ServerDeleteRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'GServer', '7', '0', 'X3', 'ServerAddRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'HTTPMethod', '0', '0', 'hm', 'HTTPMethod', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'IPO', '0', '0', 'io', 'IPO', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ListRequest', '0', '0', 'lr', 'ListRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ListResponse', '0', '0', 'lr', 'ListResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'Option', '0', '0', 'o', 'Option', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'RequestHeader', '0', '0', 'rh', 'RequestHeader', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'Server', '0', '0', 's', 'Server', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerAddResponse', '0', '0', 'sar', 'ServerAddResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteRequest', '0', '0', 'sdr', 'ServerDeleteRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerDeleteResponse', '0', '0', 'sdr', 'ServerDeleteResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditRequest', '0', '0', 'ser', 'ServerEditRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerEditResponse', '0', '0', 'ser', 'ServerEditResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetRequest', '0', '0', 'sgr', 'ServerGetRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerGetResponse', '0', '0', 'sgr', 'ServerGetResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerListResponse', '0', '0', 'slr', 'ServerListResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerRequest', '0', '0', 'spr', 'ServerPowerRequest', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'ServerPowerResponse', '0', '0', 'spr', 'ServerPowerResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '0', 'hm', 'HTTPMethod', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '0', 'qs', 'QueryString', 'Null', 'Global');
INSERT INTO `variable` VALUES ('GogridTest', 'GoGrid.asoc', 'URL', '0', '0', 'rhf', 'RequestHeaderField', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'PopResponse', '0', '0', 'por', 'PopResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'PushResponse', '0', '0', 'pur', 'PushResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'ReplaceResponse', '0', '0', 'rr', 'ReplaceResponse', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', 'pushres', 'StackService', '[s.push(x)]', 'Local');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', 's', 'StackService', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', 'x', 'Integer', 'Null', 'Global');
INSERT INTO `variable` VALUES ('StackSs', 'StackS.txt', 'StackService', '0', '0', 'y', 'Integer', 'Null', 'Global');

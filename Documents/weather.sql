MST,Max TemperatureF,Mean TemperatureF,Min TemperatureF,Max Dew
PointF,MeanDew PointF,Min DewpointF,Max Humidity, Mean Humidity, Min
Humidity, Max Sea Level PressureIn, Mean Sea Level PressureIn, Min Sea
Level PressureIn, Max VisibilityMiles, Mean VisibilityMiles, Min
VisibilityMiles, Max Wind SpeedMPH, Mean Wind SpeedMPH, Max Gust
SpeedMPH,PrecipitationIn, CloudCover, Events, WindDirDegrees

use allergy; 
CREATE TABLE weather_data(
	id INT NOT NULL AUTO_INCREMENT,
	MST DATE,
	Max_TemperatureF INT,
	Mean_TemperatureF INT,
	Min_TemperatureF INT,
	Max_Dew_PointF INT,
	MeanDew_PointF INT,
	Min_DewpointF INT,
	Max_Humidity INT, 
	Mean_Humidity INT, 
	Min_Humidity INT, 
	Max_Sea_Level_PressureIn FLOAT, 
	Mean_Sea_Level_PressureIn FLOAT, 
	Min_Sea_Level_PressureIn FLOAT, 
	Max_VisibilityMiles INT, 
	Mean_VisibilityMiles INT, 
	Min_VisibilityMiles INT, 
	Max_Wind_SpeedMPH INT, 
	Mean_Wind_SpeedMPH INT, 
	Max_Gust_SpeedMPH INT,
	PrecipitationIn FLOAT, 
	CloudCover INT, 
	Events VARCHAR(40), 
	WindDirDegrees INT,
	PRIMARY KEY ( id ) 
	); 
insert into weather_data(MST,
	Max_TemperatureF,
	Mean_TemperatureF,
	Min_TemperatureF,
	Max_Dew_PointF,
	MeanDew_PointF,
	Min_DewpointF,
	Max_Humidity, 
	Mean_Humidity, 
	Min_Humidity, 
	Max_Sea_Level_PressureIn, 
	Mean_Sea_Level_PressureIn, 
	Min_Sea_Level_PressureIn, 
	Max_VisibilityMiles, 
	Mean_VisibilityMiles, 
	Min_VisibilityMiles, 
	Max_Wind_SpeedMPH, 
	Mean_Wind_SpeedMPH, 
	Max_Gust_SpeedMPH,
	PrecipitationIn, 
	CloudCover, 
	Events, 
	WindDirDegrees) values ('2003-1-28',66,50,34,18,15,12,46,29,12,30.11,30.01,29.90,10,10,10,26,7,32,0.00,1,'',149);








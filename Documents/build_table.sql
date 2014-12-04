
use allergy; 
CREATE TABLE pollen_data(    
	id INT NOT NULL AUTO_INCREMENT,    
	submission_date DATE,    
	location VARCHAR(40) NOT NULL,    
	tree_type VARCHAR(40) NOT NULL,    
	level INT NOT NULL,
	PRIMARY KEY ( id ) ); 
insert into pollen_data (submission_date,
location, tree_type, level) values ('2004-03-01', 'EASTSIDE', 'Elm',
276);

select date_format(`pollen_data`.`submission_date`,"%b") as `submissio
n_date`,avg(if(`pollen_data`.`tree_type`='Acacia',`pollen_data`.`level
`,null)) as 'level Acacia',avg(if(`pollen_data`.`tree_type`='Alder',`p
ollen_data`.`level`,null)) as 'level Alder',avg(if(`pollen_data`.`tree
_type`='Ash',`pollen_data`.`level`,null)) as 'level Ash',avg(if(`polle
n_data`.`tree_type`='Aster',`pollen_data`.`level`,null)) as 'level Ast
er',avg(if(`pollen_data`.`tree_type`='Beech',`pollen_data`.`level`,nul
l)) as 'level Beech',avg(if(`pollen_data`.`tree_type`='Birch',`pollen_
data`.`level`,null)) as 'level Birch',avg(if(`pollen_data`.`tree_type`
='Chenopodiaceae',`pollen_data`.`level`,null)) as 'level Chenopodiacea
e',avg(if(`pollen_data`.`tree_type`='Cottonwood',`pollen_data`.`level`
,null)) as 'level Cottonwood',avg(if(`pollen_data`.`tree_type`='Elm',`
pollen_data`.`level`,null)) as 'level
Elm',avg(if(`pollen_data`.`tree_type`='End of
Season',`pollen_data`.`level`,null)) as 'level End of Season',avg(if(`
pollen_data`.`tree_type`='Ephedra',`pollen_data`.`level`,null)) as
'level Ephedra',avg(if(`pollen_data`.`tree_type`='Equipment
Error',`pollen_data`.`level`,null)) as 'level Equipment Error',avg(if(
`pollen_data`.`tree_type`='Goldenrod',`pollen_data`.`level`,null)) as
'level Goldenrod',avg(if(`pollen_data`.`tree_type`='Grass',`pollen_dat
a`.`level`,null)) as 'level Grass',avg(if(`pollen_data`.`tree_type`='H
ickory',`pollen_data`.`level`,null)) as 'level Hickory',avg(if(`pollen
_data`.`tree_type`='Juniper',`pollen_data`.`level`,null)) as 'level Ju
niper',avg(if(`pollen_data`.`tree_type`='Juniper/Cedar',`pollen_data`.
`level`,null)) as 'level Juniper/Cedar',avg(if(`pollen_data`.`tree_typ
e`='Linden',`pollen_data`.`level`,null)) as 'level Linden',avg(if(`pol
len_data`.`tree_type`='Locust',`pollen_data`.`level`,null)) as 'level 
Locust',avg(if(`pollen_data`.`tree_type`='Maple',`pollen_data`.`level`
,null)) as 'level Maple',avg(if(`pollen_data`.`tree_type`='Mesquite',`
pollen_data`.`level`,null)) as 'level Mesquite',avg(if(`pollen_data`.`
tree_type`='Mulberry',`pollen_data`.`level`,null)) as 'level Mulberry'
,avg(if(`pollen_data`.`tree_type`='Nettle',`pollen_data`.`level`,null)
) as 'level Nettle',avg(if(`pollen_data`.`tree_type`='Oak',`pollen_dat
a`.`level`,null)) as 'level Oak',avg(if(`pollen_data`.`tree_type`='Pec
an',`pollen_data`.`level`,null)) as 'level Pecan',avg(if(`pollen_data`
.`tree_type`='Pine',`pollen_data`.`level`,null)) as 'level
Pine',avg(if(`pollen_data`.`tree_type`='Pollen Count
Unavailable',`pollen_data`.`level`,null)) as 'level Pollen Count Unava
ilable',avg(if(`pollen_data`.`tree_type`='Privet',`pollen_data`.`level
`,null)) as 'level Privet',avg(if(`pollen_data`.`tree_type`='Ragweed',
`pollen_data`.`level`,null)) as 'level Ragweed',avg(if(`pollen_data`.`
tree_type`='Rumex',`pollen_data`.`level`,null)) as 'level
Rumex',avg(if(`pollen_data`.`tree_type`='Russian
Olive',`pollen_data`.`level`,null)) as 'level Russian Olive',avg(if(`p
ollen_data`.`tree_type`='Sagebrush',`pollen_data`.`level`,null)) as
'level Sagebrush',avg(if(`pollen_data`.`tree_type`='Salt
Cedar',`pollen_data`.`level`,null)) as 'level Salt
Cedar',avg(if(`pollen_data`.`tree_type`='Scorpion
Weed',`pollen_data`.`level`,null)) as 'level Scorpion
Weed',avg(if(`pollen_data`.`tree_type`='Scorpion Weed (phacelia
crenulata)',`pollen_data`.`level`,null)) as 'level Scorpion Weed
(phacelia crenulata)',avg(if(`pollen_data`.`tree_type`='Sedge',`pollen
_data`.`level`,null)) as 'level Sedge',avg(if(`pollen_data`.`tree_type
`='Sycamore',`pollen_data`.`level`,null)) as 'level Sycamore',avg(if(`
pollen_data`.`tree_type`='Unidentied',`pollen_data`.`level`,null)) as
'level Unidentied',avg(if(`pollen_data`.`tree_type`='Unidentified',`po
llen_data`.`level`,null)) as 'level Unidentified',avg(if(`pollen_data`
.`tree_type`='Walnut',`pollen_data`.`level`,null)) as 'level Walnut',a
vg(if(`pollen_data`.`tree_type`='Wattle',`pollen_data`.`level`,null))
as 'level Wattle',avg(if(`pollen_data`.`tree_type`='Willow',`pollen_da
ta`.`level`,null)) as 'level Willow' from `pollen_data` group by year(
`pollen_data`.`submission_date`),month(`pollen_data`.`submission_date`
) order by month(`pollen_data`.`submission_date`)

select `pollen_data`.`location` as
`location`,avg(`pollen_data`.`level`) as `level` from `pollen_data`
where  [dynamic_filters] group by `pollen_data`.`location` order by
`pollen_data`.`location`

select `pollen_data`.`tree_type` as
`tree_type`,avg(`pollen_data`.`level`) as `level` from `pollen_data`
group by `pollen_data`.`tree_type` order by `pollen_data`.`tree_type`

select year(`pollen_data`.`submission_date`) as
`submission_date`,avg(`pollen_data`.`level`) as `level` from
`pollen_data` group by year(`pollen_data`.`submission_date`) order by
year(`pollen_data`.`submission_date`)

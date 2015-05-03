-- Purge
DELETE FROM `doubletgenre`;
DELETE FROM `doubletlangue`;
DELETE FROM `doubletvote`;
DELETE FROM `genreactivite`;
DELETE FROM `langues`;
DELETE FROM `utilisateur`;
DELETE FROM `activite`;

-- peuplement pour genreactivite
INSERT INTO `genreactivite`(`idGenre`,`nomGenre`) VALUES (1,'Sport');
INSERT INTO `genreactivite`(`idGenre`,`nomGenre`) VALUES (2,'Randonnée');
INSERT INTO `genreactivite`(`idGenre`,`nomGenre`) VALUES (3,'Voiture');
INSERT INTO `genreactivite`(`idGenre`,`nomGenre`) VALUES (4,'Visite culturelle');

-- peuplement pour utilisateur
INSERT INTO `utilisateur`(`idUtilisateur`,`password`,`pseudo`,`email`,`sexe`,`age`,`regionOrigine`,`latitude`,`longitude`,`image`,`communication`) VALUES (1,'admin','stan','stanislas.descamps@gmail.com',1,40,'Madrid',40.4165000,-3.7025600,'monImage',false);
INSERT INTO `utilisateur`(`idUtilisateur`,`password`,`pseudo`,`email`,`sexe`,`age`,`regionOrigine`,`latitude`,`longitude`,`image`,`communication`) VALUES (2,'pass','tonton','tonton.tata@gmail.com',1,25,'Istanbul',40.4165000,-3.7025600,'monImage',true);
INSERT INTO `utilisateur`(`idUtilisateur`,`password`,`pseudo`,`email`,`sexe`,`age`,`regionOrigine`,`latitude`,`longitude`,`image`,`communication`) VALUES (3,'test','tata','tata.tonton@gmail.com',2,32,'France',48.8534100,2.3488000,'monImage',true);
INSERT INTO `utilisateur`(`idUtilisateur`,`password`,`pseudo`,`email`,`sexe`,`age`,`regionOrigine`,`latitude`,`longitude`,`image`,`communication`) VALUES (4,'heyyee','moi','moi.moi@gmail.com',2,10,'Quebec',48.8534100,2.3488000,'monImage',true);

-- peuplement pour activite
INSERT INTO `activite`(`idActivite`,`libelleActivite`,`idGenre`,`latitudeAct`,`longitudeAct`,`voteOui`,`voteNon`) VALUES (1,'OpenTennis',1,40.4165000,-3.7025600,4,0);
INSERT INTO `activite`(`idActivite`,`libelleActivite`,`idGenre`,`latitudeAct`,`longitudeAct`,`voteOui`,`voteNon`) VALUES (2,'CheminSinueux',2,40.4165000,-3.7025600,3,1);
INSERT INTO `activite`(`idActivite`,`libelleActivite`,`idGenre`,`latitudeAct`,`longitudeAct`,`voteOui`,`voteNon`) VALUES (3,'SalonAutomobile',3,48.8534100,2.3488000,1,3);
INSERT INTO `activite`(`idActivite`,`libelleActivite`,`idGenre`,`latitudeAct`,`longitudeAct`,`voteOui`,`voteNon`) VALUES (4,'Musée lambda',4,48.8534100,2.3488000,2,2);

-- peuplement pour langues
INSERT INTO `langues`(`idLangue`,`nomLangue`) VALUES (1,'Français');
INSERT INTO `langues`(`idLangue`,`nomLangue`) VALUES (2,'Anglais');
INSERT INTO `langues`(`idLangue`,`nomLangue`) VALUES (3,'Espagnol');
INSERT INTO `langues`(`idLangue`,`nomLangue`) VALUES (4,'Allemand');
INSERT INTO `langues`(`idLangue`,`nomLangue`) VALUES (5,'Japonais');

-- peuplement pour doubletlangue
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (1,1);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (1,2);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (1,3);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (2,1);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (3,1);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (3,2);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (4,2);
INSERT INTO `doubletlangue`(`idUtilisateur`,`idLangue`) VALUES (4,5);

-- peuplement pour doubletvote
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (1,1,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (1,2,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (1,3,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (1,4,1);

INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (2,1,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (2,2,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (2,3,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (2,4,0);

INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (3,1,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (3,2,0);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (3,3,0);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (3,4,0);

INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (4,1,0);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (4,2,0);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (4,3,1);
INSERT INTO `doubletvote`(`idActivite`,`idUtilisateur`,`valeurVote`) VALUES (4,4,1);

-- peuplement pour doubletgenre
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (1,1);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (2,1);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (3,1);

INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (1,2);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (2,2);

INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (1,3);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (2,3);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (4,3);

INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (4,4);
INSERT INTO `doubletgenre`(`idGenre`,`idUtilisateur`) VALUES (1,4);




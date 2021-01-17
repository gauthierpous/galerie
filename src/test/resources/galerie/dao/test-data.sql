-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, chiffre_Affaires_Annuel, nom, adresse) VALUES (1, 30000, 'Saatchi', 'King\''s Road, Londres');

INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id, somme_des_ventes) VALUES (1, '2020-03-12', 'La peinture moderne', 3, 1, 1000);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id, somme_des_ventes) VALUES (2, '2019-11-12', 'La sculpture au XIXe siècle', 4, 1, 2000);
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id, somme_des_ventes) VALUES (3, '2020-04-12', 'La photo en noir et blanc', 2, 1, 1500);

INSERT INTO Personne(id, budget_Annuel, nom, adresse) VALUES (1, 3000, 'Pierre', '39 Avenue Victor Hugo');
INSERT INTO Personne(id, budget_Annuel, nom, adresse) VALUES (2, 4000, 'Simon', '27 Rue des roses');

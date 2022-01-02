-- Get list group
SELECT ID, Name, Description FROM FriendGroup

-- Get name, des group 
SELECT Name, Description FROM FriendGroup
WHERE ID = 2

-- insert new group
INSERT INTO FriendGroup(Name, Description)
VALUES('NEW', 'NEW DES')

-- Get list contact
SELECT c.ID, c.FirstName, c.LastName, f.Name, c.PhoneNumber, c.CreatedDate 
FROM Contact c
JOIN FriendGroup f ON f.ID = c.GroupID

SELECT ID, FirstName, LastName, CreatedDate, PhoneNumber , GroupID
FROM Contact

-- Get contact
SELECT FirstName, LastName, PhoneNumber, GroupID 
FROM Contact
WHERE ID = 1

-- insert into contact
INSERT INTO Contact(FirstName, LastName, CreatedDate, PhoneNumber, GroupID)
VALUES('a', 'B', GETDATE(), '123', 1)

-- Edit contact
UPDATE Contact
SET FirstName = 'binh', LastName = 'B', GroupID = 1, PhoneNumber='1900'
WHERE ID = 2 

-- Remove contact
DELETE FROM Contact
WHERE ID = 4

-- count number of contact
SELECT COUNT(ID) FROM Contact

DELETE Contact
DBCC CHECKIDENT (Contact, RESEED, 0)

DELETE FriendGroup
DBCC CHECKIDENT (FriendGroup, RESEED, 0)
SELECT * FROM FriendGroup
SELECT * FROM Contact

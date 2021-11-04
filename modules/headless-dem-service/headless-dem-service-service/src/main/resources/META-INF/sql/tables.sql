create table HEADLESS_DE_Foo (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	fileEntryId LONG,
	fooName VARCHAR(75) null,
	fooAge INTEGER,
	fooSex INTEGER
);
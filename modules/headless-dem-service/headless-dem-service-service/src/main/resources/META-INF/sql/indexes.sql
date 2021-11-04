create index IX_A875B41 on HEADLESS_DE_Foo (fooAge);
create index IX_5C43022D on HEADLESS_DE_Foo (fooName[$COLUMN_LENGTH:75$]);
create index IX_711D64A8 on HEADLESS_DE_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B086F52A on HEADLESS_DE_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);
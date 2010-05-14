create table KB_Article (
	uuid_ VARCHAR(75) null,
	articleId LONG not null primary key,
	resourcePrimKey LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentResourcePrimKey LONG,
	version INTEGER,
	title VARCHAR(150) null,
	content TEXT null,
	description STRING null,
	priority INTEGER
);

create table KB_Template (
	uuid_ VARCHAR(75) null,
	templateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(150) null,
	content TEXT null,
	description STRING null
);
## Description
This is a FirstSpirit mocking library that can mock FirstSpirit objects for using them in tests.


## Features
* Every mock has one class with a prefix named by FirstSpirit object name and Mock as a postfix.
* A mock will a builder with a human readable fluent interface.
* Via lambdas like Supplier or Feature builders are provided that will be finalized in building via build command.


## Installation
* Maven is required
* Git is required
* Clone project via git because no public artifact is available.

### Via Maven Repo (local or remote)
#### Maven
`<dependency>
	<groupId>com.diva-e.firstspirit</groupId>
	<artifactId>firstspirit-mocks</artifactId>
	<version>${firstspirit-mocks-version}</version>
</dependency>`


## Ho to use it
Every Mock can be build via a build command like:

`Project project = BuilderMock.build(ProjectMock.projectWith("project", 0, LanguageMock.languageWith("EN")));`

By importing static methods this line could look like:

Project project = build(projectWith("project", 0, languageWith("EN")));`


### Complex mock setup

`ReferenceEntryBuilder referenceEntryBuilder = referenceEntryWith(5);

GlobalStoreRoot globalStoreRoot = build(globalStoreRootWith(1, projectWith("project", 0, languageWith("DE"))).children(parent ->
	singletonList(gcaPageWith("gcaPage", 3, parent).children(gcaPageParent -> {
		GCABodyBuilder gcaBodyBuilder = gcaBodyWith("gcaBody", 4, gcaPageParent);

		referenceEntryBuilder.aReferencedElement(gcaBodyBuilder);

		return singletonList(gcaBodyBuilder);

	})))
);

ReferenceEntry referenceEntry = build(referenceEntryBuilder);`
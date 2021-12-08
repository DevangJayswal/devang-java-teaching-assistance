## to use this plugin we have two steps

	1. initialization of jacoco code plugin so that it would be ready to generate reports
		executions
			goal1: `prepare-agent`
				it will prepare jacoco code coverage agent
			goal2: `report`, id: `generatereport`, phase:`test`
				it will be executed right after the `test` phase
	2. run the goal that will actually generate the reports for tests that are executed
		

				

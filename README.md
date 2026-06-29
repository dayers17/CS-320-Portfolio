# CS-320-Portfolio

This repository contains my work from CS-320, including the contact service from Project One and the Summary and Reflections Report from Project Two. Together, these artifacts demonstrate my ability to create unit tests using code to uncover errors, analyze various approaches to software testing based on requirements, and apply appropriate testing strategies to meet those requirements.

## Reflection

**How can I ensure that my code, program, or software is functional and secure?**

Functionality and security start with mapping every requirement to a specific, verifiable test before considering a feature complete. For the contact service, that meant writing a dedicated JUnit test for every length and null constraint defined in the requirements, then testing both the valid and invalid paths for each one. Security in this context comes from rigorous input validation. Every field rejects null values and enforces strict length and format limits, such as the phone field requiring exactly ten digits, which prevents malformed or unexpected data from corrupting the system. Running these tests through JUnit 5 with zero failures, combined with coverage analysis confirming the core classes were fully exercised, gave me confidence that the code behaves correctly under both expected and adversarial conditions.

**How do I interpret user needs and incorporate them into a program?**

User needs in this project were expressed as formal software requirements, and my role was to translate those requirements into working code without adding unstated assumptions. Each requirement, such as the contact ID needing to be unique and no longer than ten characters, was implemented as an explicit validation rule in the constructor or setter, and then verified independently through testing. This discipline matters beyond the classroom. In my own work building financial platforms, user needs are rarely as clearly specified as they were in this assignment, which means listening carefully and asking clarifying questions during elicitation is just as important as the implementation itself.

**How do I approach designing software?**

My approach to designing software is to treat the requirements as the specification and the tests as the proof that the specification has been met. I chose a `HashMap` for the contact service's in-memory storage because it provides constant time complexity for add, delete, and update operations, which keeps the design efficient regardless of how many contacts are stored. I also separated validation logic into the object class itself rather than the service layer, so that a `Contact` can never exist in an invalid state no matter how it is created or modified. This mirrors how I now think about designing systems professionally: build the constraints into the data itself first, then layer service behavior on top of a foundation that cannot be corrupted.

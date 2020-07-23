
### Newton NXT ###
---
### Regression Test ###
Once the Newton NXT app is up and running on an environment, we can run the regression tests.

To run regression test use the below command:

**mvn clean test -Denv=dev -DskipMunitTests -Dignored-tests="" -Dpassword=${POST_TEST_PASSWORD} -Dsleepminutes=10**

<details>
  <summary>Regression test setup (Click to view more)</summary>
  
#### Setup needed for the regression tests ####
We need below OAuth users

| OAuth User | Role | Instances | Description |
| ------ | ------ | ------ | ------ |
| <sub>OAuth Client for NEWTON_AUTO_TEST</sub> | <sub>NEWTON_NXT_API_CLIENT</sub> | <sub>NEWTON_AUTO_TEST_INSTANCE, NEWTON_AUTO_DELETE_TEST_INSTANCE, NEWTON_AUTO_ANON_TEST_INSTANCE, NEWTON_AUTO_API_ROLE_TEST_INSTANCE</sub> | <sub>This user is used to test all the APIs</sub>  |
| <sub>OAuth Client for NEWTON_AUTO_TEST_NO_API_CLIENT</sub> | - | - | <sub>This user is used to test that API access is not allowed when the user doesn't have the role NEWTON_NXT_API_CLIENT</sub> |
| <sub>OAuth Client for NEWTON_AUTO_TEST_NO_INSTANCES</sub> | <sub>NEWTON_NXT_API_CLIENT</sub> | - | <sub>This user is used to test that access on instance is not alowed unless user has the permission for that instance</sub> |

We need the below records in the couchbase database

| Document Id | Content | Description |
| ------ | ------ | ------ |
| <sub>7e5f3277-8efe-46e4-848d-2ab0289e23b4-role</sub> |  <sub>{<br>  "personId": "7e5f3277-8efe-46e4-848d-2ab0289e23b4",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "ADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}</sub> | <sub>This is the MODERATOR user</sub> |
| <sub>cd2919a2-58a3-4fe6-9d6a-b59310cdae8b-role</sub> | <sub>{<br>  "personId": "cd2919a2-58a3-4fe6-9d6a-b59310cdae8b",<br>  "instances": [<br>    "NEWTON_AUTO_TEST_INSTANCE",<br>    "NEWTON_AUTO_DELETE_TEST_INSTANCE",<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>    "NEWTON_AUTO_ANON_TEST_INSTANCE"<br>  ],<br>  "roles": [<br>    "SUPERADMIN"<br>  ],<br>  "resourceType": "userRole"<br>}<br></sub> | <sub>This is the SUPERADMIN user</sub> |
| <sub>249c6d75-4082-4125-b639-9d3951312abf-role</sub> | <sub>{<br>  "personId": "249c6d75-4082-4125-b639-9d3951312abf",<br>  "instances": [<br>    "NEWTON_AUTO_API_ROLE_TEST_INSTANCE",<br>  ],<br>  "roles": [<br>    "CUSTOM_ROLE"<br>  ],<br>  "resourceType": "userRole"<br>}</sub> | <sub>This use has CUSTOM_ROLE which is used to test user defined roles for API access</sub> |

We need the below users in Janrain

| Email Id | UUID | Password | Description |
| ------ | ------ | ------ | ------ |
| <sub>newton_auto_test_user@newton.digitalpfizer.com</sub> | <sub>bb9830a2-c98e-4675-a2bd-5a0913b76e5a</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for SELF role</sub> |
| <sub>newton_auto_test_proxy@newton.digitalpfizer.com</sub> | <sub>093b59ec-c424-4d0b-a2ef-21031651f063</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for PROXY role</sub> |
| <sub>newton_auto_test_moderator@newton.digitalpfizer.com</sub> | <sub>7e5f3277-8efe-46e4-848d-2ab0289e23b4</sub> | <sub>Check with Newton team</sub> | <sub>Used for MODERATOR user</sub> |
| <sub>newton_auto_test_superadmin@newton.digitalpfizer.com</sub> | <sub>cd2919a2-58a3-4fe6-9d6a-b59310cdae8b</sub> | <sub>Check with Newton team</sub> | <sub>Used for SUPERADMIN role</sub> |
| <sub>newton_auto_test_custom_role@newton.digitalpfizer.com</sub> | <sub>249c6d75-4082-4125-b639-9d3951312abf</sub> | <sub>Check with Newton team</sub> | <sub>Used for CUSTOM_ROLE role</sub> |
| <sub>newton_auto_test_1@newton.digitalpfizer.com</sub> | <sub>4e1630e1-21b5-4b9e-b446-729e4b6e44c0</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_2@newton.digitalpfizer.com</sub> | <sub>38dd7740-f328-4581-8cf0-b79fe51cf85c</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_3@newton.digitalpfizer.com</sub> | <sub>225c0ac6-2de1-4924-be48-2d1286b34852</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_4@newton.digitalpfizer.com</sub> | <sub>bca1006e-3884-46ba-81b1-db2a057b3219</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_5@newton.digitalpfizer.com</sub> | <sub>027571ea-4e34-4561-ae85-943063bdf1e0</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_6@newton.digitalpfizer.com</sub> | <sub>cd8d04a3-e760-44d5-8c52-1ca280b03837</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_7@newton.digitalpfizer.com</sub> | <sub>ed1b78f2-f250-4f2d-827c-2cea1726ef28</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_8@newton.digitalpfizer.com</sub> | <sub>98ce2cf4-644d-44b1-af85-fdbfd5fece0c</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_9@newton.digitalpfizer.com</sub> | <sub>392e9d99-21d2-405e-b065-19d98b995d0f</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_10@newton.digitalpfizer.com</sub> | <sub>3e25c511-3983-4e27-9392-2897da8ad7fd</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_11@newton.digitalpfizer.com</sub> | <sub>2c426ad2-a5a3-42d4-8401-e14984652475</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_12@newton.digitalpfizer.com</sub> | <sub>df252158-896c-458c-a646-afcaa946eae4</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_13@newton.digitalpfizer.com</sub> | <sub>c472ee13-bb6f-4c0b-b4fa-f5819a0a81b4</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_14@newton.digitalpfizer.com</sub> | <sub>8b803771-fee0-4c94-9777-e0b1f2c2f33b</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |
| <sub>newton_auto_test_15@newton.digitalpfizer.com</sub> | <sub>40e1a959-e4dd-401e-822c-374595568bde</sub> | <sub>Check with Newton team</sub> | <sub>This user is used for creating person record</sub> |

</details>

---
<details>
  <summary>Data migration</summary>
	
### Data migration ###
* Records with resourceType="person"
	* Add ```profile: {id: "JANRAIN/PING", profile: "Janrain/Ping uuid"}```
* Records with resourceType="person" or resourceType="event"
	* If encrypted, store ```securedFields:["field1", "field2"]``` in the record record itself
	* I think the code will work even if we don't make this change in the encrypted records.
* Records with resourceType="action" which update Janrain record
	* Use ```payload.profile.profileId``` instead of ```payload.id```
* Records with any resourceType but having ```isActive=false```
	* We need to delete these records
* Write GROOVY script for some defaut actions in 1.0 and update instance
	* update Janrain record during Person creation, deletion and profile linking.
* Records with resourceType="personGroup"
	* Change the field name from ```personIds``` to ```personGroup```
* Records with resourceType="event"
	* Change the field name from ```janrainId``` to ```personId```
* Records with resourceType="instance"
	* Add chained actions for person create and delete to update Janrain record
	* Add Janrain allowed method and endpoint for "entity", "entity.update". LivingWith used "signin"
	* Change "optimisticLockingEnabled" to "optimisticLockEnabled"
* Records with resourceType="assets"
	* Some of these assets are for recall service. So we have convert them to records of type "recall"
	* The "id" of the "recall" record must be equal to "attributes.appId" of the asset record
* Migrate Hardcoded Chained Actions to Groovy Chained Actions
* Migrate the contacts record
	* Split the record into multiple 	
</details>

---

### Knows issues ###
* There is some limitation on Janrain API calls. We can only make maximum of 500 API calls per minute (It includes all clients, not for a specific client). When we hit the threshold, we get the below response from Janrain registration API.
```json
	{"stat":"error","code":510,"error_description":"too many registration attempts","error":"api_limit_error","request_id":"rxn5navex8zw48hw"}
```
* The properties which we have defined as booean is RAML (E.g: isActive) accepts the quoted string "true", "false". But Couchbase doesn't treat these as boolean. Even having "enum [true, false]" didn't solve this problem.
* The JS SDK used by the hybrid applications has a method which will encode the filter parameters before invoking Newton APIs. In order to handle this scenario, Newton will attempt to decode the filters if present. The percentage symbol is used in like and not like filter criteria so make sure %25 is used instead. 
* Currently Newton NXT works only with Mulesoft 4.2.1 runtime. It fails to get deployed in 4.2.2 and higher versions.
----
### Things to do when migrated to mule runtime 4.3 ###
* In commons-action.xml we are retring the chained action groovy script execution max 5 times. Use variable instead and override the value from action record. An action can set the maxretryCount to 0, 1, 2, 3, 4 or 5. 0 means no retry.



 


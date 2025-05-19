```
Team 
    Project
        Task
            SubTask

User
-----
id
name
email
password
image

Team
----
id:int
name:text
members:User

Projects
-------
id:int
name:text
teams:Team

Task
------
id:int
instruction:text
assignee:User
estimateTime:bigInt
startTime:timestamp
endTime:timestamp
status:TaskStatus
parent:Task
remark:text

TaskStatus
-----------
Not Started
In Progress
Pending
Completed
Canceled
For Deployment
```
# Chris User Guide
This is a agent that help you manage your work.\
It can mark down jobs and events that you are going to do.\
The activities will be saved until you delete them.

## Adding todo
Todo function is just simply used to mark down what you have to finish.\
Here is the command format:\
todo {task name}
```
Example: 
todo buy water
```
```
Expected outcome:
--------------------

Got it. I've added this task:
[T][ ]buy water
--------------------

```
## Adding deadlines
Deadline function is used to record some activities that have a specific deadline.\
Here is the command format:\
deadline {task name} /by {the time of deadline}
```
Example: 
deadline assignment 1 /by 3 Sept 23:59
```

```
Expected outcome:
--------------------

Got it. I've added this task:
[D][ ] assignment 1 (by: 3 Sept 23:59)
Now you have 1 tasks in the list.
--------------------
```

## Adding events
Event function is used to record some activities that last for a period of time.\
Here is the command format:\
event {task name} /from {starting time} /to {ending time}
```
Example:
event quiz /from 3 Sept 15:00 /to 3 Sept 15:30
```
```
Expected outcome:
--------------------

Got it. I've added this task:
[E][ ] quiz (from: 3 Sept 15:00 to: 3 Sept 15:30)
Now you have 2 tasks in the list.
--------------------
```

## Listing tasks
List out all the tasks including todo, deadlines, and events.\
Here is the command format:\
list
```
Example outcome:
--------------------

Here are the tasks in your list:

1.[T][ ]buy water
2.[D][ ] assignment 1 (by: 3 Sept 23:59)
3.[E][ ] quiz (from: 3 Sept 15:00 to: 3 Sept 15:30)
--------------------
```

## Deleting tasks
Delete function is used to delete tasks you have saved based the indexing by the list function.\
Here is the command format:\
delete {index of the task in list}
```
Example: 
delete 3
```
```
Expected outcome:
--------------------

Noted. I've deleted this task:

[E][ ] quiz (from: 3 Sept 15:00 to: 3 Sept 15:30)
You now have 2 tasks in the list.
--------------------
```
You can also use list to check the remaining task.In this example,you should expect the followings:
```
--------------------

Here are the tasks in your list:

1.[T][ ]buy water
2.[D][ ] assignment 1 (by: 3 Sept 23:59)
--------------------
```

## Mark the tasks
Mark function is used to note the tasks as finish based on the indexing of the list.\
Ypu can see the notation showing the status when using list.\
[X] represents finish while [ ] represents not yet finish.\
Here is the command format:\
mark {index of task specified by list}
```
Example: 
mark 2
```
```
Expected outcome:
--------------------

Nice! I've marked this task as done:

[D][X] assignment 1 (by: 3 Sept 23:59)
--------------------
```
You can also see the changes when using list.
```
list
--------------------

Here are the tasks in your list:

1.[T][ ]buy water
2.[D][X] assignment 1 (by: 3 Sept 23:59)
--------------------
```

## Unmarking the tasks
Unmark the finished tasks based on the indexing of the list.\
Change their status from finished to not yet finish.\
Here is the command format:\
unmark {index of the task in the list}
```
Example:
unmark 2
```
```
Expected outcome:
--------------------

OK, I've marked this task as not done yet:

[D][ ] assignment 1 (by: 3 Sept 23:59)
--------------------
```
You can also see the changes in the list.The status of task 2 become [ ] again.\
```
--------------------

Here are the tasks in your list:

1.[T][ ]buy water
2.[D][ ] assignment 1 (by: 3 Sept 23:59)
--------------------
```

## Find your task
Find function is used to search your task based on the keyword you entered.\
It will list out all the tasks containing the keyword.\
Here is command format:\
find {keyword}
```
Example: 
find water
```
```
Expected outcome:
--------------------

Here are the matching tasks:

[T][ ]buy water
--------------------
```

## End the conversation
Time to say goodbye!\
This function is used to terminate the agent.\
It will save all the undeleted tasks to a file.\
Here is the command format:\
bye
```
Expected outcome:
--------------------

Bye. Hope to see you again soon!
--------------------
```
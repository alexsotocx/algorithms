class BusinessTasks:
  def getTask(self, tasks, n):
    tasks = list(tasks)
    i = 0
    while len(tasks) > 1 :
      i = (i + n -1) % len(tasks)
      del tasks[i]
    return(tasks[0])

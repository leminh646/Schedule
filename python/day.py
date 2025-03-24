from employee import Employee

class Day:
    def __init__(self, name):
        self.name = name
        self.shifts = {"morning": [], "afternoon": [], "evening": []}
    
    def assign_employee(self, shift, employee: Employee):
        if shift in self.shifts:
            self.shifts[shift].append(employee.name)
    
    def get_assigned_employees(self):
        return self.shifts

from employee import Employee

class Day:
    def __init__(self, day):
        self.day = day
        self.shifts = {"morning": [], "afternoon": [], "evening": []}
    
    def assign_employee(self, shift, employee: Employee):
        self.shifts[shift].append(employee.name)
    
    def get_assigned_employees(self):
        return self.shifts

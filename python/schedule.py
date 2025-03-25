from employee import Employee
from day import Day
import random


class Schedule:
    def __init__(self):
        self.days = {day: Day(day) for day in ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]}
        self.employees = {}

    def add_employee(self, name):
        self.employees[name] = Employee(name)

    def set_employee_preference(self, name, day, shift):
        if name in self.employees and day in self.days:
            self.employees[name].set_preference(day, shift)

    def assign_shifts(self):
        for day_name, day_obj in self.days.items():
            assigned = set()
            for shift in day_obj.shifts:
                available = [e for e in self.employees.values() if e.preferences.get(day_name) == shift and e.workdays < 5]
                random.shuffle(available)

                while len(day_obj.shifts[shift]) < 2:
                    if available:
                        emp = available.pop()
                        day_obj.assign_employee(shift, emp)
                        emp.workdays += 1
                        assigned.add(emp.name)

                    else:
                        remaining = [e for e in self.employees.values() if e.workdays < 5 and e.name not in assigned]
                        if remaining:
                            emp = random.choice(remaining)
                            day_obj.assign_employee(shift, emp)
                            emp.workdays += 1
                            assigned.add(emp.name)
                        else:
                            break

    def display_schedule(self):
        print("\nFinal Schedule:")
        for day_name, day_obj in self.days.items():
            print(f"\n{day_name}:")
            for shift, employees in day_obj.get_assigned_employees().items():
                print(f"  {shift.capitalize()}: {', '.join(employees) if employees else 'No employees assigned'}")

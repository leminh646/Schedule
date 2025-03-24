from schedule import Schedule

if __name__ == "__main__":
    scheduler = Schedule()
    scheduler.add_employee("Alice")
    scheduler.add_employee("Bob")
    scheduler.add_employee("Charlie")

    scheduler.set_employee_preference("Alice", "Monday", "morning")
    scheduler.set_employee_preference("Alice", "Tuesday", "afternoon")
    scheduler.set_employee_preference("Bob", "Monday", "evening")
    scheduler.set_employee_preference("Charlie", "Monday", "morning")
    scheduler.set_employee_preference("Charlie", "Tuesday", "evening")

    scheduler.assign_shifts()
    scheduler.display_schedule()
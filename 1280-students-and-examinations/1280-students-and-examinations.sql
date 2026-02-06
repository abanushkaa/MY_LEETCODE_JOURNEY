SELECT distinct
    s.student_id,
    s.student_name,su.subject_name,
    COUNT( e.subject_name) AS attended_exams
FROM students s join subjects su
left JOIN examinations e
    ON e.student_id = s.student_id
    and su.subject_name = e.subject_name
GROUP BY 
    su.subject_name, s.student_id
order by s.student_id,su.subject_name;

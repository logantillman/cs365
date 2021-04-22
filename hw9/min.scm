(define min
  (lambda (l)
    (cond
      ((null? l) '())
      ((null? (cdr l)) (car l))
      (#t (minHelper (cdr l) (car l))))))

(define (minHelper l x)
    (if (< (length l) 2) 
        (if (< (car l) x) (car l) x)
        (minHelper (cdr l) (let ((a (car l)))
                            (if (< a x) a x)))))
; Author: Logan Tillman

; swap.scm
(define (swap x y)
    (if (< x y)
        (cons x y)
        (cons y x)))

; avg.scm
(define (sum L)
    (cond
        ((null? L) 0)
        (#t (+ (car L) (sum (cdr L))))))

(define (avg L)
    (cond 
        ((null? L) 0)
        (#t (/ (* (sum L) 1.0) (length L)))))

; min.scm
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
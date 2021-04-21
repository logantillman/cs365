(define (sum L)
    (cond
        ((null? L) 0)
        (#t (+ (car L) (sum (cdr L))))))

(define (avg L)
    (/ (* (sum L) 1.0) (length L)))
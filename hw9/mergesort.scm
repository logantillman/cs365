(define (mergesort L)
    (cond
        ((null? L) '())
        ((null? (cdr L)) L)
        (#t (merge (mergesort (car (mergesortHelper L))) (mergesort (car (cdr (mergesortHelper L))))))))

(define (mergesortHelper L)
    (cond
        ((null? L) (list '() '()))
        ((null? (cdr L)) (list L '()))
        (#t (list (cons (car L) (car (mergesortHelper (cdr (cdr L)))))
                  (cons (car (cdr L)) (car (cdr (mergesortHelper (cdr (cdr L))))))))))

(define (merge L1 L2)
    (cond
        ((null? L1) L2)
        ((null? L2) L1)
        (#t (if (< (car L1) (car L2))
                    (cons (car L1) (merge (cdr L1) L2))
                    (cons (car L2) (merge (cdr L2) L1))))))
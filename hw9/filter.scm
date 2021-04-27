(define (filter func L)
    (filterHelper func L '()))

(define (filterHelper func L R)
    (if (null? L) 
        R
        (if (func (car L)) 
            (filterHelper func (cdr L) (append R (list (car L))))
            (filterHelper func (cdr L) R))))
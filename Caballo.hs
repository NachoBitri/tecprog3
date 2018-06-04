import System.CPUTime
import Data.List

type Pos = (Int, Int) 
type Camino = [Pos]
type Board = (Int,Camino)
type Nodo = (Board,Bool)

iniBoard :: Int -> Pos -> Board
iniBoard n p = (n,[p])

addSalto :: Pos -> Board -> Board
addSalto p (t,b) = (t,p:b) 

saltosPos :: Board -> Camino
saltosPos (t,b) = [ p | (dx, dy) <- [(-1,2),(1,2),(2,1),(2,-1),(1,-2),(-1,-2),(-2,-1),(-2,1)]
						,let x = dx+f, x <= t, x > 0, let y = dy+c, y <= t, y > 0, let p = (x,y)
						, p `notElem` b]
							where 
								(f,c) = head b

coger :: [Nodo] -> Nodo
coger t
	| length t == 1 = head t
	| let (b,boo) = head t, boo==True = (b,boo)
	| otherwise = coger (drop 1 t)

busqueda :: Board -> Nodo
busqueda t 
	| let (n,b) = t, n*n == length b = (t,True)
	| null (saltosPos t)  = (t,False)
	| otherwise = coger [ busqueda (addSalto mov t)| mov <- saltosPos t]

main :: IO()
main = do
	if boo == True then print $ reverse c
	else putStrLn("No hay solucion")
	where
		n = 5
		pos=(1,1)
		a = iniBoard n pos
		((t,c),boo) = busqueda a

		
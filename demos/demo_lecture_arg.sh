function wait {
	read -p "Appuyez sur n'importe quelle touche pour continuer... " -n1 -s
	clear
}

echo "==================================================="
echo "======= Démonstration Lecture des Arguments ======="
echo "==================================================="

echo "Sans aucun arguments :"
wait
./bl_demo.sh

echo "Avec un argument (-help) mais sans paramètre"
wait
./bl_demo.sh -help

echo "Avec un argument, possédant un paramètre (-help mel)"
wait
./bl_demo.sh -help mel

echo "Fin de la démonstration 'Lecture des Arguments'"
wait
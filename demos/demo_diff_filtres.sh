function wait {
	read -p "Appuyez sur n'importe quelle touche pour continuer... " -n1 -s
	clear
}

echo "================================================"
echo "======= Démonstration différents Filtres ======="
echo "================================================"

echo "Application du filtre Estampage"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -es

echo "Application du filtre Gradient vers la droite, couplé à InverserValeur"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -grad 1 -ival

echo "Application du filtre Inverser Valeur"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -ival

echo "Application du filtre Négatif"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -neg

echo "Application du filtre Netteté"
wait
./bl_demo.sh ../assets/input.ppm -o ../assets/ouput.ppm -nt

echo "Application du filtre Seuil"
wait
./bl_demo.sh ../assets/input_color.ppm -o ../assets/ouput.ppm -sel 120
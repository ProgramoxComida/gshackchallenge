<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$router->get('/api/v1/pedidos', 'PedidosController@getPedidos');
$router->get('/api/v1/pedidos/{pedidos_id}', 'PedidosController@getPedido');
$router->get('/api/v1/pedidos/{pedidos_id}/tracking', 'PedidosController@getPedidoTracking');

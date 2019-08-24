<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

/**
 * @OA\Schema(
 *     schema="Error",
 *      @OA\Property(
 *          property="error",
 *          type="string",
 *          description="Mensaje de Error"
 *    ),
 * )
 */
/**
 * @OA\Schema(
 *     schema="Pedido",
 *      @OA\Property(
 *          property="id",
 *          type="integer",
 *          description="Id de Pedido"
 *    ),
 * )
 */
class Pedido extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        '', 'email',
    ];
}

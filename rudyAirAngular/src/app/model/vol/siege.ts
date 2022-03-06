export class Siege {
  private _id: number | undefined;
  private _numero: number | undefined;
  private _avion: Avion | undefined;

  constructor(id: number, numero: number, avion: Avion) {
    this._id = id;
    this._numero = numero;
    this._avion = avion;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter numero
   * @return {number }
   */
  public get numero(): number | undefined {
    return this._numero;
  }

  /**
   * Getter avion
   * @return {Avion }
   */
  public get avion(): Avion | undefined {
    return this._avion;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter numero
   * @param {number } value
   */
  public set numero(value: number | undefined) {
    this._numero = value;
  }

  /**
   * Setter avion
   * @param {Avion } value
   */
  public set avion(value: Avion | undefined) {
    this._avion = value;
  }
}

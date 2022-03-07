import { Avion } from './avion';
import { StatutVol } from './statut-vol';

export class Vol {
  private _id: number | undefined;
  private _numeroVol: string | undefined;
  private _dateDepart: Date | undefined;
  private _dateArrivee: Date | undefined;
  private _statutVol: StatutVol | undefined;
  private _volGenerique: VolGenerique | undefined;
  private _avion: Avion | undefined;
  private _reservation: Reservation | undefined;

  constructor(
    id?: number,
    numeroVol?: string,
    dateDepart?: Date,
    dateArrivee?: Date,
    statutVol?: StatutVol,
    volGenerique?: VolGenerique,
    avion?: Avion,
    reservation?: Reservation
  ) {
    this._id = id;
    this._numeroVol = numeroVol;
    this._dateDepart = dateDepart;
    this._dateArrivee = dateArrivee;
    this._statutVol = statutVol;
    this._volGenerique = volGenerique;
    this._avion = avion;
    this._reservation = reservation;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | undefined {
    return this._id;
  }

  /**
   * Getter numeroVol
   * @return {string }
   */
  public get numeroVol(): string | undefined {
    return this._numeroVol;
  }

  /**
   * Getter dateDepart
   * @return {Date }
   */
  public get dateDepart(): Date | undefined {
    return this._dateDepart;
  }

  /**
   * Getter dateArrivee
   * @return {Date }
   */
  public get dateArrivee(): Date | undefined {
    return this._dateArrivee;
  }

  /**
   * Getter statutVol
   * @return {StatutVol }
   */
  public get statutVol(): StatutVol | undefined {
    return this._statutVol;
  }

  /**
   * Getter volGenerique
   * @return {VolGenerique }
   */
  public get volGenerique(): VolGenerique | undefined {
    return this._volGenerique;
  }

  /**
   * Getter avion
   * @return {Avion }
   */
  public get avion(): Avion | undefined {
    return this._avion;
  }

  /**
   * Getter reservation
   * @return {Reservation }
   */
  public get reservation(): Reservation | undefined {
    return this._reservation;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | undefined) {
    this._id = value;
  }

  /**
   * Setter numeroVol
   * @param {string } value
   */
  public set numeroVol(value: string | undefined) {
    this._numeroVol = value;
  }

  /**
   * Setter dateDepart
   * @param {Date } value
   */
  public set dateDepart(value: Date | undefined) {
    this._dateDepart = value;
  }

  /**
   * Setter dateArrivee
   * @param {Date } value
   */
  public set dateArrivee(value: Date | undefined) {
    this._dateArrivee = value;
  }

  /**
   * Setter statutVol
   * @param {StatutVol } value
   */
  public set statutVol(value: StatutVol | undefined) {
    this._statutVol = value;
  }

  /**
   * Setter volGenerique
   * @param {VolGenerique } value
   */
  public set volGenerique(value: VolGenerique | undefined) {
    this._volGenerique = value;
  }

  /**
   * Setter avion
   * @param {Avion } value
   */
  public set avion(value: Avion | undefined) {
    this._avion = value;
  }

  /**
   * Setter reservation
   * @param {Reservation } value
   */
  public set reservation(value: Reservation | undefined) {
    this._reservation = value;
  }
}
